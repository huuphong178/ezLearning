/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import bus.CourseBUS;
import com.google.gson.JsonObject;
import dao.CourseDAO;
import dto.Course;
import dto.CourseExt;
import dto.PopularCourse;
import dto.PromotionCourse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.GenerateIDUtil;
import util.StringUtil;

/**
 *
 * @author lap11916
 */
public class CourseHandler extends BaseHandler{
    
    private final CourseBUS bus = new CourseBUS(new CourseDAO());
    private final SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    protected String doGetHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        
        switch (pathInfo) {
            case "/":
                String query = req.getQueryString();                
                Collection<CourseExt> listCourse = new ArrayList<>();          
                if(!StringUtil.isEmpty(query)){
                    Map<String, String> params = StringUtil.getParams(query, "&");
                    String id = params.get("id");
                    if(!StringUtil.isEmpty(id)){
                        String selectFrom = "SELECT *, IFNULL(percentage, 0) as 'percentage2' FROM (SELECT c.*, cat.name as 'catname', u.displayname as 'teachername'"
                            + " FROM course c, category cat, user u";
                        String where = " WHERE c.catid = cat.id AND u.username = c.teacherid AND c.id = '" + id + "') table1";
                        String sql = selectFrom + where + " LEFT JOIN voucher v ON table1.id = v.courseid;";
                        System.out.println("SQL: " + sql);
                        
                        ArrayList<String[]> item = bus.executeSelectSQL(sql);
                        if(!item.isEmpty())
                            listCourse.add(new CourseExt(item.get(0)));
                    }
                }else{
                    String selectFrom = "SELECT *, IFNULL(percentage, 0) as 'percentage2' FROM (SELECT c.*, cat.name as 'catname', u.displayname as 'teachername'"
                            + " FROM course c, category cat, user u";
                    String where = " WHERE c.catid = cat.id AND u.username = c.teacherid) table1";
                    String sql = selectFrom + where + " LEFT JOIN voucher v ON table1.id = v.courseid;";
                    System.out.println("SQL: " + sql);

                    ArrayList<String[]> items = bus.executeSelectSQL(sql);
                    
                    for(String[] i : items){
                        listCourse.add(new CourseExt(i));
                    }
                }
                
                if(!listCourse.isEmpty())
                    return gson.toJson(listCourse);
                break;
            case "/random":
                String queryRandom = req.getQueryString();                
                Collection<CourseExt> listCourseRandom = new ArrayList<>();
                if(!StringUtil.isEmpty(queryRandom)){
                    Map<String, String> params = StringUtil.getParams(queryRandom, "&");
                    String n = params.get("n");
                    if(!StringUtil.isEmpty(n)){
                        ArrayList<CourseExt> temptList = new ArrayList<>();
                        HashMap<Integer, Integer> indexUsed = new HashMap<>();
                        
                        String selectFrom = "SELECT *, IFNULL(percentage, 0) as 'percentage2' FROM (SELECT c.*, cat.name as 'catname', u.displayname as 'teachername'"
                            + " FROM course c, category cat, user u";
                        String where = " WHERE c.catid = cat.id AND u.username = c.teacherid) table1";
                        String sql = selectFrom + where + " LEFT JOIN voucher v ON table1.id = v.courseid;";
                        System.out.println("SQL: " + sql);

                        ArrayList<String[]> items = bus.executeSelectSQL(sql);

                        for(String[] i : items){
                            temptList.add(new CourseExt(i));
                        }
                        int number = Integer.parseInt(n);
                        int loop = number <= temptList.size() ? number : temptList.size();
                        for(int i = 0; i < loop; i++){
                            Random rand = new Random(); 
                            int index = rand.nextInt(temptList.size());
                            if(indexUsed.containsKey(index)){
                                i--;
                            }else{
                                indexUsed.put(index, index);
                                listCourseRandom.add(temptList.get(index));
                            }
                        }
                    }
                }
                
                if(!listCourseRandom.isEmpty())
                    return gson.toJson(listCourseRandom);
                break;
            case "/promotion":
                String queryPromotion = req.getQueryString();                
                Collection<PromotionCourse> listCoursePromotion = new ArrayList<>();
                if(!StringUtil.isEmpty(queryPromotion)){
                    Map<String, String> params = StringUtil.getParams(queryPromotion, "&");
                    Long timestampFrom = Long.parseLong(params.get("from"));
                    Long timestampTo = Long.parseLong(params.get("to"));
                    String from = sdf.format(new Date(timestampFrom));              //params.get("from");
                    String to = sdf.format(new Date(timestampTo));   
                    String n = params.get("n");
                    if(!StringUtil.isEmpty(from) && !StringUtil.isEmpty(to)){
                        ArrayList<PromotionCourse> temptList = new ArrayList<>();
                        String selectFrom = "SELECT c.id, c.name, c.rating, c.price, c.catid, cat.name as 'catname', u.displayname as 'teachername', u.avatar, v.percentage, v.from_date, v.to_date, c.description"
                                            + " FROM course c, user u, category cat, voucher v";
                        String where = " WHERE ((v.from_date <= '" + to + "' AND '" + to + "' <= v.to_date) OR (v.to_date >= '" + from + "' AND '" + from + "' >= v.from_date) "
                                + "OR (v.from_date >= '" + from + "' AND v.to_date <= '" + to + "'))"
                                + " AND c.catid = cat.id AND c.teacherid = u.username AND c.id = v.courseid";
                        String sql = selectFrom + where;
                        
                        System.out.println("SQL: " + sql);
                        
                        ArrayList<String[]> tempt = bus.executeSelectSQL(sql);
                        for(String[] str : tempt){
                            PromotionCourse item = new PromotionCourse(str);
                            Long price = Long.parseLong(item.getPrice());
                            Long sale = (price * Long.parseLong(item.getPercentage()))/100;
                            Long promotionalPrice = price-sale;
                            item.setPromotionalPrice(promotionalPrice.toString());
                            temptList.add(item);
                        }
                        
                        if(!StringUtil.isEmpty(n)){
                            int number = Integer.parseInt(n);
                            int loop = number <= temptList.size() ? number : temptList.size();
                            for(int i =0 ;i < loop;i++){
                                listCoursePromotion.add(temptList.get(i));
                            }
                        }else{
                            listCoursePromotion.addAll(temptList);
                        }
                        
                    }
                }
                
                if(!listCoursePromotion.isEmpty())
                    return gson.toJson(listCoursePromotion);
                break;
            case "/popular":
                String queryPopular = req.getQueryString();                
                Collection<PopularCourse> listPopularCourse = new ArrayList<>();
                if(true){
                    Map<String, String> params = StringUtil.getParams(queryPopular, "&");
                    String n = params.get("n");
                    
                    ArrayList<PopularCourse> temptList = new ArrayList<>();
                    String selectFrom = "SELECT *, IFNULL(percentage, 0) as 'percentage2' FROM (SELECT receipt.courseid, c.name as 'coursename', c.price, u.username, u.avatar, c.rating, cat.id as 'catid', cat.name as 'catname', count(*), u.displayname as 'teachername', c.description"
                            + " FROM receiptdetail receipt, category cat, course c, user u";
                    String where = " WHERE c.id = receipt.courseid AND c.catid = cat.id AND c.teacherid = u.username"
                            + " GROUP BY receipt.courseid"
                            + " ORDER BY count(*) DESC) table1";
                    String sql = selectFrom + where + " LEFT JOIN voucher v ON table1.courseid = v.courseid;";
                    System.out.println("SQL: " + sql);

                    ArrayList<String[]> tempt = bus.executeSelectSQL(sql);
                    for (String[] str : tempt) {
                        PopularCourse item = new PopularCourse(str);
                        temptList.add(item);
                    }

                    if (!StringUtil.isEmpty(n)) {
                        int number = Integer.parseInt(n);
                        int loop = number <= temptList.size() ? number : temptList.size();
                        for (int i = 0; i < loop; i++) {
                            listPopularCourse.add(temptList.get(i));
                        }
                    } else {
                        listPopularCourse.addAll(temptList);
                    }
                }
                
                if(!listPopularCourse.isEmpty())
                    return gson.toJson(listPopularCourse);
                break;
            case "/rating":
                String queryRating = req.getQueryString();                
                Collection<PopularCourse> listRatingCourse = new ArrayList<>();
                if(true){
                    Map<String, String> params = StringUtil.getParams(queryRating, "&");
                    String n = params.get("n");
                    
                    ArrayList<PopularCourse> temptList = new ArrayList<>();
                    String selectFrom = "SELECT *, IFNULL(percentage, 0) as 'percentage2' FROM (SELECT c.id, c.name as 'coursename', c.price, u.username, u.avatar, c.rating, cat.id as 'catid', cat.name as 'catname', '1', u.displayname as 'teachername', c.description"
                            + " FROM category cat, course c, user u";
                    String where = " WHERE c.catid = cat.id AND c.teacherid = u.username"
                            + " ORDER BY rating DESC) table1";
                    String sql = selectFrom + where + " LEFT JOIN voucher v ON table1.id = v.courseid;";
                    System.out.println("SQL: " + sql);

                    ArrayList<String[]> tempt = bus.executeSelectSQL(sql);
                    for (String[] str : tempt) {
                        PopularCourse item = new PopularCourse(str);
                        temptList.add(item);
                    }

                    if (!StringUtil.isEmpty(n)) {
                        int number = Integer.parseInt(n);
                        int loop = number <= temptList.size() ? number : temptList.size();
                        for (int i = 0; i < loop; i++) {
                            listRatingCourse.add(temptList.get(i));
                        }
                    } else {
                        listRatingCourse.addAll(temptList);
                    }
                }
                
                if(!listRatingCourse.isEmpty())
                    return gson.toJson(listRatingCourse);
                break;
            case "/new":
                String queryNew = req.getQueryString();                
                Collection<PopularCourse> listRatingNew = new ArrayList<>();
                if(true){
                    Map<String, String> params = StringUtil.getParams(queryNew, "&");
                    String n = params.get("n");
                    
                    ArrayList<PopularCourse> temptList = new ArrayList<>();
                    String selectFrom = "SELECT *, IFNULL(percentage, 0) as 'percentage2' FROM (SELECT c.id, c.name as 'coursename', c.price, u.username, u.avatar, c.rating, cat.id as 'catid', cat.name as 'catname', c.date, u.displayname as 'teachername', c.description"
                            + " FROM category cat, course c, user u";
                    String where = " WHERE c.catid = cat.id AND c.teacherid = u.username"
                            + " ORDER BY date DESC) table1";
                    String sql = selectFrom + where + " LEFT JOIN voucher v ON table1.id = v.courseid;";
                    System.out.println("SQL: " + sql);

                    ArrayList<String[]> tempt = bus.executeSelectSQL(sql);
                    for (String[] str : tempt) {
                        PopularCourse item = new PopularCourse(str);
                        temptList.add(item);
                    }

                    if (!StringUtil.isEmpty(n)) {
                        int number = Integer.parseInt(n);
                        int loop = number <= temptList.size() ? number : temptList.size();
                        for (int i = 0; i < loop; i++) {
                            listRatingNew.add(temptList.get(i));
                        }
                    } else {
                        listRatingNew.addAll(temptList);
                    }
                }
                
                if(!listRatingNew.isEmpty())
                    return gson.toJson(listRatingNew);
                break;
            case "/teach":
                String queryTeach = req.getQueryString();                
                Collection<CourseExt> listCourseTeach = new ArrayList<>();
                if(!StringUtil.isEmpty(queryTeach)){
                    Map<String, String> params = StringUtil.getParams(queryTeach, "&");
                    String n = params.get("n");
                    String id = params.get("teacherid");
                    
                    String selectFrom = "SELECT *, IFNULL(percentage, 0) as 'percentage2' FROM (SELECT c.*, cat.name as 'catname', u.displayname as 'teachername'"
                            + " FROM course c, user u, category cat";
                    String where = " WHERE cat.id = c.catid AND c.teacherid = u.username AND c.teacherid = '" + id + "' ORDER BY c.date DESC ) table1";
                    String sql = selectFrom + where + " LEFT JOIN voucher v ON table1.id = v.courseid;";
                    System.out.println("SQL: " + sql);
                    
                    
                    ArrayList<CourseExt> temptList = new ArrayList<>();
                    ArrayList<String[]> tempt = bus.executeSelectSQL(sql);
                    for (String[] str : tempt) {
                        CourseExt item = new CourseExt(str);
                        temptList.add(item);
                    }
                    
                    if(!StringUtil.isEmpty(n)){
                        Integer number = Integer.parseInt(n);
                        int loop = number <= temptList.size() ? number : temptList.size();
                        for(int i = 0; i < loop; i++){                          
                            listCourseTeach.add(temptList.get(i));
                        }
                    }else{
                        listCourseTeach.addAll(temptList);
                    }
                }
                
                if(!listCourseTeach.isEmpty())
                    return gson.toJson(listCourseTeach);
                break;
            case "/studentid":
                String queryStudentID = req.getQueryString();                
                Collection<CourseExt> listCourseStudentID = new ArrayList<>();
                if(!StringUtil.isEmpty(queryStudentID)){
                    Map<String, String> params = StringUtil.getParams(queryStudentID, "&");
                    String n = params.get("n");
                    String id = params.get("id");
                    
                    String selectFrom = "SELECT *, IFNULL(percentage, 0) as 'percentage2' FROM (SELECT c.*, cat.name as 'catname', u.displayname as 'teachername'"
                            + " FROM course c, receiptdetail re, user u, category cat";
                    String where = " WHERE c.id = re.courseid AND re.studentid = '" + id + "' AND u.username = c.teacherid AND cat.id = c.catid ORDER BY re.id DESC) table1";
                    String sql = selectFrom + where + " LEFT JOIN voucher v ON table1.id = v.courseid;";
                    System.out.println("SQL: " + sql);
                    
                    
                    ArrayList<CourseExt> temptList = new ArrayList<>();
                    ArrayList<String[]> tempt = bus.executeSelectSQL(sql);
                    for (String[] str : tempt) {
                        CourseExt item = new CourseExt(str);
                        temptList.add(item);
                    }
                    
                    if(!StringUtil.isEmpty(n)){
                        Integer number = Integer.parseInt(n);
                        int loop = number <= temptList.size() ? number : temptList.size();
                        for(int i = 0; i < loop; i++){                          
                            listCourseStudentID.add(temptList.get(i));
                        }
                    }else{
                        listCourseStudentID.addAll(temptList);
                    }
                }
                
                if(!listCourseStudentID.isEmpty())
                    return gson.toJson(listCourseStudentID);
                break;
            case "/search":
                return doSearch(req);
            case "/voucher":
                String queryCheckVoucher = req.getQueryString();                
                if(!StringUtil.isEmpty(queryCheckVoucher)){
                    Map<String, String> params = StringUtil.getParams(queryCheckVoucher, "&"); 
                    String id = params.get("id");
                    if(!StringUtil.isEmpty(id)){
                        String selectFrom = "SELECT c.id, c.price, v.percentage"
                                            + " FROM voucher v, course c";
                        String where = " WHERE c.id = v.courseid  AND c.id = '" + id + "'";
                        String sql = selectFrom + where;
                        
                        System.out.println("SQL: " + sql);
                        
                        ArrayList<String[]> tempt = bus.executeSelectSQL(sql);
                        
                        if(!tempt.isEmpty()){
                            String[] item = tempt.get(0);
                            Long price = Long.parseLong(item[1]);
                            Long percentage = Long.parseLong(item[2]);
                            Long sale = (price * percentage)/100;
                            Long promotionalPrice = price-sale;
                            
                            JsonObject obj = new JsonObject();
                            obj.addProperty("price", price.toString());
                            obj.addProperty("percentage", percentage.toString());
                            obj.addProperty("promotionalPrice", promotionalPrice.toString());
                            
                            return obj.toString();
                            
                        }
                    }
                }
                
                break;
        }
        
        return "";
    }

    @Override
    protected void doPostHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        
        switch (pathInfo) {
            case "/":
                String json = getRequestBody(req);
                Course item = gson.fromJson(json, Course.class);
                item.setId(GenerateIDUtil.GenerateID());
                bus.insert(item);
                break;  
        }
    }

    @Override
    protected void doPutHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            System.err.println("Empty");
        } else {
            String id = pathInfo.substring(1);
            String bodyData = getRequestBody(req);
            Course item = gson.fromJson(bodyData, Course.class);
            bus.update(id, item);
        }
    }

    @Override
    protected void doDeleteHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        //chua get du lieu dc.
    }
    
    private String doSearch(HttpServletRequest req) throws Exception{
        String query = req.getQueryString();
        Map<String, String> params = StringUtil.getParams(query, "&");
        String catID = params.get("catid");
        ArrayList<CourseExt> temptList = new ArrayList<>();

        if (catID != null) {
            String sql = "SELECT *, IFNULL(percentage, 0) as 'percentage2' FROM (SELECT c.*, cat.name as 'catname', u.displayname as 'teachername'"
                    + " FROM course c, category cat, user u"
                    + " WHERE c.catid = cat.id AND u.username = c.teacherid AND c.catid = " + catID + " ) table1"
                    + " LEFT JOIN voucher v ON table1.id = v.courseid;";
            System.out.println("SQL: " + sql);

            ArrayList<String[]> tempt = bus.executeSelectSQL(sql);
            for (String[] str : tempt) {
                CourseExt item = new CourseExt(str);
                temptList.add(item);
            }

            if (!temptList.isEmpty()) {
                String json = gson.toJson(temptList);
                String[] str = tempt.get(0);
                String catName = str[str.length - 1];
                return "{ \"catName\": " + "\"" + catName + "\"," + "\"courses\":" + json + "}";
            }
        } else {
            String courseName = req.getParameter("coursename");
            String teacherName = req.getParameter("teachername");
            String categoryName = req.getParameter("categoryname");
            String sql = "";
            if(courseName != null){
                sql = "SELECT *, IFNULL(percentage, 0) as 'percentage2' FROM (SELECT c.*, cat.name as 'catname', u.displayname as 'teachername'"
                    + " FROM course c, category cat, user u"
                    + " WHERE c.name LIKE '%" + courseName + "%' AND c.catid = cat.id AND u.username = c.teacherid) table1"
                    + " LEFT JOIN voucher v ON table1.id = v.courseid;";
                System.out.println("SQL: " + sql);   
            }else if(teacherName != null){
                sql = "SELECT *, IFNULL(percentage, 0) as 'percentage2' FROM (SELECT c.*, cat.name as 'catname', u.displayname as 'teachername'"
                    + " FROM course c, user u, category cat"
                    + " WHERE c.teacherid = u.username AND c.catid = cat.id AND u.displayname LIKE '%" + teacherName + "%') table1"
                    + " LEFT JOIN voucher v ON table1.id = v.courseid;";
                System.out.println("SQL: " + sql); 
            }else if(categoryName != null){
                sql = "SELECT *, IFNULL(percentage, 0) as 'percentage2' FROM (SELECT c.*, cat.name as 'catname', u.displayname as 'teachername'"
                    + " FROM course c, category cat, user u"
                    + " WHERE c.catid = cat.id AND c.teacherid = u.username AND cat.name LIKE '%" + categoryName + "%' ) table1"
                    + " LEFT JOIN voucher v ON table1.id = v.courseid;";
                System.out.println("SQL: " + sql); 
            }
            
            ArrayList<String[]> tempt = bus.executeSelectSQL(sql);
            for (String[] str : tempt) {
                CourseExt item = new CourseExt(str);
                temptList.add(item);
            }
            
            if (!temptList.isEmpty()) {
                return gson.toJson(temptList);
            }
        }
        
        return "";
    }
    
}

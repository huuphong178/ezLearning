/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import bus.CourseBUS;
import dao.CourseDAO;
import dto.Course;
import dto.PopularCourse;
import dto.PromotionCourse;
import java.util.ArrayList;
import java.util.Collection;
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
    
    @Override
    protected String doGetHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        
        switch (pathInfo) {
            case "/":
                String query = req.getQueryString();                
                Collection<Course> listCourse = new ArrayList<>();
                if(!StringUtil.isEmpty(query)){
                    Map<String, String> params = StringUtil.getParams(query, "&");
                    String id = params.get("id");
                    if(!StringUtil.isEmpty(id)){
                        Course item = bus.getOne(id);
                        if(item!=null)
                            listCourse.add(item);
                    }
                }else{
                    listCourse = bus.getAll();
                }
                
                if(!listCourse.isEmpty())
                    return gson.toJson(listCourse);
                break;
            case "/random":
                String queryRandom = req.getQueryString();                
                Collection<Course> listCourseRandom = new ArrayList<>();
                if(!StringUtil.isEmpty(queryRandom)){
                    Map<String, String> params = StringUtil.getParams(queryRandom, "&");
                    String n = params.get("n");
                    if(!StringUtil.isEmpty(n)){
                        ArrayList<Course> temptList = new ArrayList<>();
                        HashMap<Integer, Integer> indexUsed = new HashMap<>();
                        temptList = bus.getAll();
                        for(int i = 0; i < Integer.parseInt(n); i++){
                            Random rand = new Random(); 
                            int index = rand.nextInt(temptList.size());
                            if(indexUsed.containsKey(index)){
                                i--;
                            }else{
                                indexUsed.put(index, index);
                            }
                            
                            listCourseRandom.add(temptList.get(index));
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
                    String from = params.get("from");
                    String to = params.get("to");
                    String n = params.get("n");
                    if(!StringUtil.isEmpty(from) && !StringUtil.isEmpty(to)){
                        ArrayList<PromotionCourse> temptList = new ArrayList<>();
                        String selectFrom = "SELECT c.id, c.name, c.rating, c.price, c.catid, cat.name as 'catname', u.displayname as 'teachername', u.avatar, v.percentage, v.from_date, v.to_date"
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
                    String selectFrom = "SELECT receipt.courseid, c.name as 'coursename', c.price, u.username, u.avatar, c.rating, cat.id as 'catid', cat.name as 'catname', count(*)"
                            + " FROM receiptdetail receipt, category cat, course c, user u";
                    String where = " WHERE c.id = receipt.courseid AND c.catid = cat.id AND c.teacherid = u.username"
                            + " GROUP BY receipt.courseid"
                            + " ORDER BY count(*) DESC";
                    String sql = selectFrom + where;
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
                    String selectFrom = "SELECT c.id, c.name as 'coursename', c.price, u.username, u.avatar, c.rating, cat.id as 'catid', cat.name as 'catname', '1'"
                            + " FROM category cat, course c, user u";
                    String where = " WHERE c.catid = cat.id AND c.teacherid = u.username"
                            + " ORDER BY rating DESC";
                    String sql = selectFrom + where;
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
                    String selectFrom = "SELECT c.id, c.name as 'coursename', c.price, u.username, u.avatar, c.rating, cat.id as 'catid', cat.name as 'catname', c.date"
                            + " FROM category cat, course c, user u";
                    String where = " WHERE c.catid = cat.id AND c.teacherid = u.username"
                            + " ORDER BY date DESC";
                    String sql = selectFrom + where;
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
                Collection<Course> listCourseTeach = new ArrayList<>();
                if(!StringUtil.isEmpty(queryTeach)){
                    Map<String, String> params = StringUtil.getParams(queryTeach, "&");
                    String n = params.get("n");
                    String id = params.get("teacherid");
                    
                    String selectFrom = "SELECT c.*"
                            + " FROM course c, user u";
                    String where = " WHERE c.teacherid = u.username AND c.teacherid = '" + id + "' ORDER BY c.date DESC";
                    String sql = selectFrom + where;
                    System.out.println("SQL: " + sql);
                    
                    
                    ArrayList<Course> temptList = new ArrayList<>();
                    ArrayList<String[]> tempt = bus.executeSelectSQL(sql);
                    for (String[] str : tempt) {
                        Course item = new Course(str);
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
                Collection<Course> listCourseStudentID = new ArrayList<>();
                if(!StringUtil.isEmpty(queryStudentID)){
                    Map<String, String> params = StringUtil.getParams(queryStudentID, "&");
                    String n = params.get("n");
                    String id = params.get("id");
                    
                    String selectFrom = "SELECT c.*"
                            + " FROM course c, receiptdetail re";
                    String where = " WHERE c.id = re.courseid AND re.studentid = '" + id + "' ORDER BY re.id DESC";
                    String sql = selectFrom + where;
                    System.out.println("SQL: " + sql);
                    
                    
                    ArrayList<Course> temptList = new ArrayList<>();
                    ArrayList<String[]> tempt = bus.executeSelectSQL(sql);
                    for (String[] str : tempt) {
                        Course item = new Course(str);
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
        ArrayList<Course> temptList = new ArrayList<>();

        if (catID != null) {
            String sql = "SELECT c.*, cat.name"
                    + " FROM course c, category cat"
                    + " WHERE c.catid = cat.id AND c.catid = " + catID;
            System.out.println("SQL: " + sql);

            ArrayList<String[]> tempt = bus.executeSelectSQL(sql);
            for (String[] str : tempt) {
                Course item = new Course(str);
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
                sql = "SELECT *"
                    + " FROM course"
                    + " WHERE name LIKE '%" + courseName + "%'";
                System.out.println("SQL: " + sql);   
            }else if(teacherName != null){
                sql = "SELECT c.*"
                    + " FROM course c, user u"
                    + " WHERE c.teacherid = u.username AND u.displayname LIKE '%" + teacherName + "%'";
                System.out.println("SQL: " + sql); 
            }else if(categoryName != null){
                sql = "SELECT c.*"
                    + " FROM course c, category cat"
                    + " WHERE c.catid = cat.id AND cat.name LIKE '%" + categoryName + "%'";
                System.out.println("SQL: " + sql); 
            }
            
            ArrayList<String[]> tempt = bus.executeSelectSQL(sql);
            for (String[] str : tempt) {
                Course item = new Course(str);
                temptList.add(item);
            }
            
            if (!temptList.isEmpty()) {
                return gson.toJson(temptList);
            }
        }
        
        return "";
    }
    
}

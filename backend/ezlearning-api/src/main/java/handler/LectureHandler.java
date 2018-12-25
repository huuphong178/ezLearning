/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import bus.LectureBUS;
import dao.LectureDAO;
import dto.Lecture;
import dto.LectureExt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.GenerateIDUtil;
import util.StringUtil;

/**
 *
 * @author lap11916
 */
public class LectureHandler extends BaseHandler{
    
    private final LectureBUS bus = new LectureBUS(new LectureDAO());
    
    @Override
    protected String doGetHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        
        switch (pathInfo) {
            case "/":
                String query = req.getQueryString();                
                Collection<Lecture> listLecture = new ArrayList<>();
                if(!StringUtil.isEmpty(query)){
                    Map<String, String> params = StringUtil.getParams(query, "&");
                    String id = params.get("id");
                    if(!StringUtil.isEmpty(id)){
                        Lecture item = bus.getOne(id);
                        if(item!=null)
                            listLecture.add(item);
                    }
                }else{
                    listLecture = bus.getAll();
                }
                
                if(!listLecture.isEmpty())
                    return gson.toJson(listLecture);
            break;    
            case "/course":
                String queryCourseID = req.getQueryString(); 
                Collection<LectureExt> listLectureExt = new ArrayList<>();
                if(!StringUtil.isEmpty(queryCourseID)){
                    Map<String, String> params = StringUtil.getParams(queryCourseID, "&");
                    String id = params.get("id");
                    
                    String selectFrom = "SELECT c.id, c.name, ch.id as 'chapter id', ch.chapter_order, ch.name as 'chapter name', lec.id as 'lecture id', lec.name as 'lecture name', lec.date, lec.videopath, lec.docpath"
                            + " FROM course c, chapter ch, lecture lec";
                    String where = " WHERE c.id = ch.courseid AND lec.chapterid = ch.id AND c.id = '" + id + "'" 
                            + " ORDER BY ch.id, lec.id";
                    String sql = selectFrom + where;
                    System.out.println("SQL: " + sql);
                    
                    ArrayList<String[]> list = bus.executeSelectSQL(sql);
                    LectureExt item = new LectureExt(list);
                    listLectureExt.add(item);
                }
                
                if(!listLectureExt.isEmpty())
                    return gson.toJson(listLectureExt);
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
                Lecture item = gson.fromJson(json, Lecture.class);
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
            Lecture item = gson.fromJson(bodyData, Lecture.class);
            bus.update(id, item);
        }
    }

    @Override
    protected void doDeleteHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        //chua get du lieu dc.
    }
    
}

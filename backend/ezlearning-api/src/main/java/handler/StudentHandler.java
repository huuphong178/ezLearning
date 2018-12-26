/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import bus.StudentBUS;
import bus.UserBUS;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dao.StudentDAO;
import dao.UserDAO;
import dto.Student;
import dto.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.StringUtil;

/**
 *
 * @author Phong Nguyen
 */
public class StudentHandler extends BaseHandler {

    private final UserBUS bus = new UserBUS(new UserDAO());
    private final StudentBUS studentbus = new StudentBUS(new StudentDAO());

    @Override
    protected String doGetHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        String query = req.getQueryString();
        switch (pathInfo) {
            case "/":
                Collection<Student> listTeach = new ArrayList<>();
                if (!StringUtil.isEmpty(query)) {
                    Map<String, String> params = StringUtil.getParams(query, "&");
                    String username = params.get("username");
                    if (!StringUtil.isEmpty(username)) {
                        Student item = studentbus.getOne(username);
                        if (item != null) {
                            listTeach.add(item);
                        }
                    }
                } else {
                    listTeach = studentbus.getAll();
                }
                if (!listTeach.isEmpty()) {
                    return gson.toJson(listTeach);
                }
                break;
            case "/historyTransaction":
                if (!StringUtil.isEmpty(query)) {
                    Map<String, String> params = StringUtil.getParams(query, "&");
                    String username = params.get("username");
                    System.err.println(username);
                    if (!StringUtil.isEmpty(username)) {
                        JsonArray result=studentbus.getHistoryTransaction(username);
                        return result.toString();
                    }
                }
                break;
        }
        return "";
    }

    @Override
    protected void doPostHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {

    }

    @Override
    protected void doPutHandler(HttpServletRequest req, HttpServletResponse resp) throws IOException, Exception {

    }

    @Override
    protected void doDeleteHandler(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

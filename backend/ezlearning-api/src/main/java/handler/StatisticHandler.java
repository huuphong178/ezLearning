/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import bus.TeacherBUS;
import bus.UserBUS;
import com.google.gson.JsonObject;
import dao.TeacherDAO;
import dao.UserDAO;
import dto.Teacher;
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
public class StatisticHandler extends BaseHandler {

    private final UserBUS bus = new UserBUS(new UserDAO());

    @Override
    protected String doGetHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        switch (pathInfo) {
            case "/":
                JsonObject result = bus.thongkeCourseStudentTeacher();
                System.err.println(result);
                return result.toString();
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

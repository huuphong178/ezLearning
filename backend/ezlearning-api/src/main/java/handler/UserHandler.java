/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import bus.UserBUS;
import com.google.gson.JsonObject;
import dao.UserDAO;
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
public class UserHandler extends BaseHandler {

    private final UserBUS bus = new UserBUS(new UserDAO());

    @Override
    protected String doGetHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        switch (pathInfo) {
            case "/":
                String query = req.getQueryString();
                Collection<User> listUser = new ArrayList<>();
                if (!StringUtil.isEmpty(query)) {
                    Map<String, String> params = StringUtil.getParams(query, "&");
                    String username = params.get("username");
                    if (!StringUtil.isEmpty(username)) {
                        User item = bus.getOne(username);
                        if (item != null) {
                            listUser.add(item);
                        }
                    }
                } else {
                    listUser = bus.getAll();
                }
                if (!listUser.isEmpty()) {
                    return gson.toJson(listUser);
                }
        }
        return "";
    }

    @Override
    protected void doPostHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        ServletOutputStream out = resp.getOutputStream();
        String body = getRequestBody(req);
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        switch (pathInfo) {
            case "/":
               // User user = (User) gson.fromJson(body, User.class);
              //  bus.insert(user);
                break;
            case "/login":
                boolean status = true;
                JsonObject obj = gson.fromJson(body, JsonObject.class);
                String username = obj.get("username").getAsString();
                String password = obj.get("password").getAsString();
                User ret = bus.login(username, password);
                if (ret != null) {
                    out.print("{\"status\": \"true\"}");
                } else {
                    out.print("{\"status\": \"false\"}");
                }
                resp.setStatus(HttpServletResponse.SC_OK);
                break;
            case "/signup":
                User user = (User) gson.fromJson(body, User.class);
                if(bus.insert(user)!=0)
                    out.print("{\"status\": \"true\"}");
                resp.setStatus(HttpServletResponse.SC_OK);
                break;
        }
    }

    @Override
    protected void doPutHandler(HttpServletRequest req, HttpServletResponse resp) throws IOException, Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            System.err.println("Empty");
        } else {
            String id = pathInfo.substring(1);
            String body = getRequestBody(req);
            User user = (User) gson.fromJson(body, User.class);
            bus.update(id, user);
        }
    }

    @Override
    protected void doDeleteHandler(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

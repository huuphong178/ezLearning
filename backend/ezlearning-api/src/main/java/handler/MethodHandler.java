/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import bus.MethodBUS;
import dao.MethodDAO;
import dto.Method;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.GenerateIDUtil;
import util.StringUtil;

/**
 *
 * @author Phong Nguyen
 */
public class MethodHandler extends BaseHandler {

    private final MethodBUS bus = new MethodBUS(new MethodDAO());
    @Override
    protected String doGetHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        switch (pathInfo) {
            case "/":
                String query = req.getQueryString();
                Collection<Method> listMethod = new ArrayList<>();
                if (!StringUtil.isEmpty(query)) {
                    Map<String, String> params = StringUtil.getParams(query, "&");
                    String id = params.get("id");
                    if (!StringUtil.isEmpty(id)) {
                        Method item = bus.getOne(id);
                        if (item != null) {
                            listMethod.add(item);
                        }
                    }
                } else {
                    listMethod = bus.getAll();
                }
                if (!listMethod.isEmpty()) {
                    return gson.toJson(listMethod);
                }
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
                String body = getRequestBody(req);
                Method method = (Method) gson.fromJson(body, Method.class);
                method.setId(GenerateIDUtil.GenerateID());
                bus.insert(method);
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
            Method method = (Method) gson.fromJson(body, Method.class);
            bus.update(id, method);
        }   
    }

    @Override
    protected void doDeleteHandler(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

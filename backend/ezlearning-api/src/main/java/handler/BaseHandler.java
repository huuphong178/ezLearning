/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Phong Nguyen
 */
public abstract class BaseHandler extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        ServletOutputStream out = resp.getOutputStream();
        Gson gson = new Gson();
        try {
            out.print(gson.toJson("hello"));
          //  out.flush();
        } catch (Exception ex) {
            out.print("fail");
            out.flush();
        }
    }

    protected abstract void doGetHandler(HttpServletRequest req, HttpServletResponse resp);

    protected abstract void doPostHandler(HttpServletRequest req, HttpServletResponse resp);

    protected abstract void doPutHandler(HttpServletRequest req, HttpServletResponse resp);

    protected abstract void doDeleteHandler(HttpServletRequest req, HttpServletResponse resp);

}

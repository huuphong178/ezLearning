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
import util.ResultUtil;

/**
 *
 * @author Phong Nguyen
 */
public abstract class BaseHandler extends HttpServlet {

    protected final Gson gson = new Gson();
    private final String resultERROR = "{\"Result\": \"" + ResultUtil.ERROR + "\"}";
    private final String resultSUCCESS = "{\"Result\": \"" + ResultUtil.SUCCESS + "\"}";

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        ServletOutputStream out = resp.getOutputStream();
        try {
            doDeleteHandler(req, resp);
            out.print(resultSUCCESS);
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            out.print(resultERROR);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } finally {
            out.flush();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        ServletOutputStream out = resp.getOutputStream();
        try {
            doPutHandler(req, resp);
            out.print(resultSUCCESS);
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            out.print(resultERROR);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } finally {
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        ServletOutputStream out = resp.getOutputStream();
        try {
            doPostHandler(req, resp);
            //out.print(resultSUCCESS);
            //resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            out.print(resultERROR);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } finally {
            out.flush();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        ServletOutputStream out = resp.getOutputStream();
        try {
            String jsonStr = doGetHandler(req, resp);
            if (jsonStr.isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                out.print(jsonStr);
                resp.setStatus(HttpServletResponse.SC_OK);
            }
        } catch (Exception ex) {
            out.print(resultERROR);
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } finally {
            out.flush();
        }
    }

    protected String getRequestBody(HttpServletRequest req) throws IOException {
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = req.getReader().readLine()) != null) {
            sb.append(s);
        }
        return sb.toString();
    }

    protected abstract String doGetHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception;

    protected abstract void doPostHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception;

    protected abstract void doPutHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception;

    protected abstract void doDeleteHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}

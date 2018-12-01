/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Phong Nguyen
 */
public class UserHandler extends BaseHandler{

    @Override
    protected void doGetHandler(HttpServletRequest req, HttpServletResponse resp) {
        
    }

    @Override
    protected void doPostHandler(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPutHandler(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doDeleteHandler(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

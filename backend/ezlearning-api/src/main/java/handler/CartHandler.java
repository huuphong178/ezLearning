/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import bus.CartBUS;
import dao.CartDAO;
import dto.Cart;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.StringUtil;

/**
 *
 * @author lap11916
 */
public class CartHandler extends BaseHandler{
    
    private final CartBUS bus = new CartBUS(new CartDAO());
    
    @Override
    protected String doGetHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        
        switch (pathInfo) {
            case "/":
                String query = req.getQueryString();                
                Collection<Cart> listCart = new ArrayList<>();
                if(!StringUtil.isEmpty(query)){
                    Map<String, String> params = StringUtil.getParams(query, "&");
                    String userID = params.get("userid");
                    String courseID = params.get("courseid");
                    if(!StringUtil.isEmpty(userID) && !StringUtil.isEmpty(courseID)){
                        Cart item = bus.getOne(userID + "|" + courseID);
                        if(item!=null)
                            listCart.add(item);
                    }
                }else{
                    listCart = bus.getAll();
                }
                
                if(!listCart.isEmpty())
                    return gson.toJson(listCart);
                break;
            case "/userid":
                String query2 = req.getQueryString();                
                Collection<Cart> listCart2 = new ArrayList<>();
                if(!StringUtil.isEmpty(query2)){
                    Map<String, String> params = StringUtil.getParams(query2, "&");
                    String userID = params.get("userid");
                    if(!StringUtil.isEmpty(userID)){
                        listCart2.addAll(bus.getByUserID(userID));
                    }
                }
                
                if (!listCart2.isEmpty()) {
                    return gson.toJson(listCart2);
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
                String json = getRequestBody(req);
                Cart item = gson.fromJson(json, Cart.class);
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
            Cart item = gson.fromJson(bodyData, Cart.class);
            bus.update(id, item);
        }
    }

    @Override
    protected void doDeleteHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        //chua get du lieu dc.
    }
    
}

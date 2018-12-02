/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import bus.CategoryBUS;
import dao.CategoryDAO;
import dto.Category;
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
public class CategoryHandler extends BaseHandler{
    
    private final CategoryBUS bus = new CategoryBUS(new CategoryDAO());
    
    @Override
    protected String doGetHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        
        switch (pathInfo) {
            case "/":
                String query = req.getQueryString();                
                Collection<Category> listCategory = new ArrayList<>();
                if(!StringUtil.isEmpty(query)){
                    Map<String, String> params = StringUtil.getParams(query, "&");
                    String id = params.get("id");
                    if(!StringUtil.isEmpty(id)){
                        Category item = bus.getOne(id);
                        listCategory.add(item);
                    }
                }else{
                    listCategory = bus.getAll();
                }
                
                if(!listCategory.isEmpty())
                    return gson.toJson(listCategory);
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
                String json = req.getParameter("data");
                Category item = gson.fromJson(json, Category.class);
                bus.insert(item);
                break;  
        }
    }

    @Override
    protected void doPutHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        
        switch (pathInfo) {
            case "/":
                String json = req.getParameter("data");
                Category item = gson.fromJson(json, Category.class);
                bus.update(item.getId(), item);
                break;  
        }
    }

    @Override
    protected void doDeleteHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        //chua get du lieu dc.
    }
    
}

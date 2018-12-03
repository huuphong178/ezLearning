/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import bus.ReceiptDetailBUS;
import dao.ReceiptDetailDAO;
import dto.ReceiptDetail;
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
public class ReceiptDetailHandler extends BaseHandler {

    private final ReceiptDetailBUS bus = new ReceiptDetailBUS(new ReceiptDetailDAO());
    @Override
    protected String doGetHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        switch (pathInfo) {
            case "/":
                String query = req.getQueryString();
                Collection<ReceiptDetail> listReceiptDetail = new ArrayList<>();
                if (!StringUtil.isEmpty(query)) {
                    Map<String, String> params = StringUtil.getParams(query, "&");
                    String id = params.get("id");
                    if (!StringUtil.isEmpty(id)) {
                        ReceiptDetail item = bus.getOne(id);
                        if (item != null) {
                            listReceiptDetail.add(item);
                        }
                    }
                } else {
                    listReceiptDetail = bus.getAll();
                }
                if (!listReceiptDetail.isEmpty()) {
                    return gson.toJson(listReceiptDetail);
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
                ReceiptDetail receiptdetail = (ReceiptDetail) gson.fromJson(body, ReceiptDetail.class);
                receiptdetail.setId(GenerateIDUtil.GenerateID());
                bus.insert(receiptdetail);
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
            ReceiptDetail receiptdetail = (ReceiptDetail) gson.fromJson(body, ReceiptDetail.class);
            bus.update(id, receiptdetail);
        }   
    }

    @Override
    protected void doDeleteHandler(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import bus.ReceiptBUS;
import dao.ReceiptDAO;
import dto.Receipt;
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
public class ReceiptHandler extends BaseHandler {

    private final ReceiptBUS bus = new ReceiptBUS(new ReceiptDAO());
    @Override
    protected String doGetHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        switch (pathInfo) {
            case "/":
                String query = req.getQueryString();
                Collection<Receipt> listReceipt = new ArrayList<>();
                if (!StringUtil.isEmpty(query)) {
                    Map<String, String> params = StringUtil.getParams(query, "&");
                    String id = params.get("id");
                    if (!StringUtil.isEmpty(id)) {
                        Receipt item = bus.getOne(id);
                        if (item != null) {
                            listReceipt.add(item);
                        }
                    }
                } else {
                    listReceipt = bus.getAll();
                }
                if (!listReceipt.isEmpty()) {
                    return gson.toJson(listReceipt);
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
                Receipt receipt = (Receipt) gson.fromJson(body, Receipt.class);
                receipt.setId(GenerateIDUtil.GenerateID());
                bus.insert(receipt);
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
            Receipt receipt = (Receipt) gson.fromJson(body, Receipt.class);
            bus.update(id, receipt);
        }   
    }

    @Override
    protected void doDeleteHandler(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

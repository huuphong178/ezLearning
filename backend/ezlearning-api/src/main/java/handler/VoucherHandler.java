/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import bus.VoucherBUS;
import dao.VoucherDAO;
import dto.Voucher;
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
public class VoucherHandler extends BaseHandler {

    private final VoucherBUS bus = new VoucherBUS(new VoucherDAO());
    @Override
    protected String doGetHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String pathInfo = req.getPathInfo();
        if (StringUtil.isEmpty(pathInfo)) {
            pathInfo = "/";
        }
        switch (pathInfo) {
            case "/":
                String query = req.getQueryString();
                Collection<Voucher> listVoucher = new ArrayList<>();
                if (!StringUtil.isEmpty(query)) {
                    Map<String, String> params = StringUtil.getParams(query, "&");
                    String id = params.get("id");
                    if (!StringUtil.isEmpty(id)) {
                        Voucher item = bus.getOne(id);
                        if (item != null) {
                            listVoucher.add(item);
                        }
                    }
                } else {
                    listVoucher = bus.getAll();
                }
                if (!listVoucher.isEmpty()) {
                    return gson.toJson(listVoucher);
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
                Voucher voucher = (Voucher) gson.fromJson(body, Voucher.class);
                voucher.setId(GenerateIDUtil.GenerateID());
                bus.insert(voucher);
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
            Voucher voucher = (Voucher) gson.fromJson(body, Voucher.class);
            bus.update(id, voucher);
        }   
    }

    @Override
    protected void doDeleteHandler(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

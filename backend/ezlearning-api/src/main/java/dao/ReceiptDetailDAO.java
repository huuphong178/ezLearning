/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ReceiptDetail;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phong Nguyen
 */
public class ReceiptDetailDAO extends ObjectDAO<ReceiptDetail> {

    @Override
    public ArrayList<ReceiptDetail> getAll() throws Exception{
        String sql = "select * from receiptdetail";
        ArrayList<String[]> receiptdetails = new ArrayList<>(XTData.loadData(sql));
        ArrayList<ReceiptDetail> result = new ArrayList<>();
        for (String[] row : receiptdetails) {
            ReceiptDetail user = new ReceiptDetail(row);
            result.add(user);
        }
        return result;
    }

    @Override
    public ReceiptDetail getOne(String id) throws Exception{
        String sql = "select * from receiptdetail where id=" + id;
        ReceiptDetail item = null;
        ArrayList<String[]> receiptdetails = new ArrayList<>(XTData.loadData(sql));
        if (!receiptdetails.isEmpty()) {
            item = new ReceiptDetail(receiptdetails.get(0));
        }
        return item;
    }

    @Override
    public int insert(ReceiptDetail dto) throws Exception{
            String sql = "Insert Into receiptdetail(id, receiptid, studentid, courseid , voucherid, status, code) Values(?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getReceiptid());
            ps.setString(3, dto.getStudentid());
            ps.setString(4, dto.getCourseid());
            ps.setString(5, dto.getVoucherid());
            ps.setInt(6, dto.getStatus());
            ps.setString(7, dto.getCode());
            return ps.executeUpdate();
    }

    @Override
    public int update(String id, ReceiptDetail dto) throws Exception{
            String sql = "update receiptdetail set receiptid =?, studentid =?, courseid = ? , voucherid = ?, status =?, code=? where id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getReceiptid());
            ps.setString(2, dto.getStudentid());
            ps.setString(3, dto.getCourseid());
            ps.setString(4, dto.getVoucherid());
            ps.setInt(5, dto.getStatus());
            ps.setString(6, dto.getCode());
            ps.setString(7, id);
            return ps.executeUpdate();
    }

    @Override
    public int delete(String id) throws Exception{
        String sql = "delete from receiptdetail where id=" + id;
        return XTData.runSQL(sql);
    }

}

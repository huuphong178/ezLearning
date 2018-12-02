/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Receipt;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phong Nguyen
 */
public class ReceiptDAO extends ObjectDAO<Receipt> {

    @Override
    public ArrayList<Receipt> getAll() throws Exception{
        String sql = "select * from receipt";
        ArrayList<String[]> receipts = new ArrayList<>(XTData.loadData(sql));
        ArrayList<Receipt> result = new ArrayList<>();
        for (String[] row : receipts) {
            Receipt user = new Receipt(row);
            result.add(user);
        }
        return result;
    }

    @Override
    public Receipt getOne(String id) throws Exception{
        String sql = "select * from receipt where id=" + id;
        Receipt item = null;
        ArrayList<String[]> receipts = new ArrayList<>(XTData.loadData(sql));
        if (!receipts.isEmpty()) {
            item = new Receipt(receipts.get(0));
        }
        return item;
    }

    @Override
    public int insert(Receipt dto) throws Exception{
            String sql = "Insert Into receipt(id, address, studentid, total , date, method) Values(?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getAddress());
            ps.setString(3, dto.getStudentid());
            ps.setLong(4, dto.getTotal());
            ps.setString(5, dto.getDate());
            ps.setInt(6, dto.getMethod());
            return ps.executeUpdate();
    }

    @Override
    public int update(String id, Receipt dto) throws Exception{
            String sql = "update receipt set address =?, studentid =?, total = ? , date = ?, method =? where id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getAddress());
            ps.setString(2, dto.getStudentid());
            ps.setLong(3, dto.getTotal());
            ps.setString(4, dto.getDate());
            ps.setInt(5, dto.getMethod());
            ps.setString(6, id);
            return ps.executeUpdate();
    }

    @Override
    public int delete(String id) throws Exception{
        String sql = "delete from receipt where id=" + id;
        return XTData.runSQL(sql);
    }

}

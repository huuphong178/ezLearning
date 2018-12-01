/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Voucher;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phong Nguyen
 */
public class VoucherDAO extends ObjectDAO<Voucher> {

    @Override
    public ArrayList<Voucher> getAll() {
        String sql="select * from voucher";
        ArrayList<String[]> vouchers= new ArrayList<>(XTData.loadData(sql));
        ArrayList<Voucher> result=new ArrayList<>();
        for(String[] row:vouchers){
            Voucher user=new Voucher(row);
            result.add(user);
        }
        return result;
    }

    @Override
    public Voucher getOne(String id) {
        String sql="select * from voucher where id="+id;
        Voucher item = null;
        ArrayList<String[]> vouchers= new ArrayList<>(XTData.loadData(sql));
        if(!vouchers.isEmpty()){
            item = new Voucher(vouchers.get(0));
        }
        return item;
    }

    @Override
    public int insert(Voucher dto) {
        try {
            String sql = "Insert Into voucher(id, name, code, from_date , to_date, percentage, courseid) Values(?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getCode());
            ps.setString(4, dto.getFrom());
            ps.setString(5, dto.getTo());
            ps.setInt(6, dto.getPercentage());
            ps.setString(7, dto.getCourseid());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(String id, Voucher dto) {
         try {
            String sql = "update voucher set name =?, code =?, from_date = ? , to_date = ?, percentage =?, courseid=? where id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getCode());
            ps.setString(3, dto.getFrom());
            ps.setString(4, dto.getTo());
            ps.setInt(5, dto.getPercentage());
            ps.setString(6, dto.getCourseid());
             ps.setString(7, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int delete(String id) {
         String sql ="delete from voucher where id="+id;
         return XTData.runSQL(sql);
    }

}

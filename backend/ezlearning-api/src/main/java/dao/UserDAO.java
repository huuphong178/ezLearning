/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phong Nguyen
 */
public class UserDAO extends ObjectDAO<User> {

    @Override
    public ArrayList<User> getAll() {
        String sql = "select * from user";
        ArrayList<String[]> users = new ArrayList<>(XTData.loadData(sql));
        ArrayList<User> result = new ArrayList<>();
        for (String[] row : users) {
            User user = new User(row);
            result.add(user);
        }
        return result;
    }

    @Override
    public User getOne(String username) {
        String sql = "select * from user where username='" + username+"'";
        User item = null;
        ArrayList<String[]> users = new ArrayList<>(XTData.loadData(sql));
        if (!users.isEmpty()) {
            item = new User(users.get(0));
        }
        return item;
    }

    @Override
    public int insert(User dto) {
        try {
            String sql = "Insert Into user(username, password, email, role , displayname, address, phone, degree, dob) Values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getUsername());
            ps.setString(2, dto.getPassword());
            ps.setString(3, dto.getEmail());
            ps.setInt(4, dto.getRole());
            ps.setString(5, dto.getDisplayname());
            ps.setString(6, dto.getAddress());
            ps.setString(7, dto.getPhone());
            ps.setString(8, dto.getDegree());
            ps.setString(9, dto.getDob());
            //ps.setBytes(10, dto.getAvartar());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(String username, User dto) {
        try {
            String sql = "update user set password =?, email = ? , role = ?, displayname =?, address=?, phone=?, degree=?, dob=? where username =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getPassword());
            ps.setString(2, dto.getEmail());
            ps.setInt(3, dto.getRole());
            ps.setString(4, dto.getDisplayname());
            ps.setString(5, dto.getAddress());
            ps.setString(6, dto.getPhone());
            ps.setString(7, dto.getDegree());
            ps.setString(8, dto.getDob());
            ps.setString(9, username);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int delete(String username) {
        String sql = "delete from user where username='" + username+"'";
        return XTData.runSQL(sql);
    }

}

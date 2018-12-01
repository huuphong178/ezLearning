/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Rating;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phong Nguyen
 */
public class RatingDAO extends ObjectDAO<Rating> {

    @Override
    public ArrayList<Rating> getAll() {
        String sql = "select * from rating";
        ArrayList<String[]> ratings = new ArrayList<>(XTData.loadData(sql));
        ArrayList<Rating> result = new ArrayList<>();
        for (String[] row : ratings) {
            Rating rating = new Rating(row);
            result.add(rating);
        }
        return result;
    }

    @Override
    public Rating getOne(String id) {
        String sql = "select * from rating where id=" + id;
        Rating item = null;
        ArrayList<String[]> ratings = new ArrayList<>(XTData.loadData(sql));
        if (!ratings.isEmpty()) {
            item = new Rating(ratings.get(0));
        }
        return item;
    }

    @Override
    public int insert(Rating dto) {
        try {
            String sql = "Insert Into rating(id, courseid, race, userid , date) Values(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getCourseid());
            ps.setInt(3, dto.getRace());
            ps.setString(4, dto.getUserid());
            ps.setString(5, dto.getDate());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RatingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(String id, Rating dto) {
        try {
            String sql = "update rating set courseid =?, race =?, userid = ? , date = ? where id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getCourseid());
            ps.setInt(2, dto.getRace());
            ps.setString(3, dto.getUserid());
            ps.setString(4, dto.getDate());
            ps.setString(5, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RatingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int delete(String id) {
        String sql = "delete from rating where id=" + id;
        return XTData.runSQL(sql);
    }

}

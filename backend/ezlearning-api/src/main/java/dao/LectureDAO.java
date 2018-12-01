/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Lecture;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lap11916
 */
public class LectureDAO extends ObjectDAO<Lecture>{

    @Override
    public ArrayList<Lecture> getAll() {
        String sql="select * from lecture";
        ArrayList<String[]> lectures= new ArrayList<>(XTData.loadData(sql));
        ArrayList<Lecture> result=new ArrayList<>();
        
        for(String[] row : lectures){
            Lecture lecture = new Lecture(row);
            result.add(lecture);
        }
        return result;
    }

    @Override
    public Lecture getOne(String id) {
        String sql="select * from lecture where id = " + id;
        ArrayList<String[]> lectures= new ArrayList<>(XTData.loadData(sql));
        
        Lecture item = null;
        if(!lectures.isEmpty()){
            item = new Lecture(lectures.get(0));
        }
        
        return item;
    }

    @Override
    public int insert(Lecture dto) {
        try {
            String sql = "INSERT INTO lecture(id, name, date, videopath, docpath, chapterid) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getDate());
            ps.setString(4, dto.getVideopath());
            ps.setString(5, dto.getDocpath());
            ps.setString(6, dto.getChapterid());
            
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LectureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

    @Override
    public int update(String id, Lecture dto) {
        try {
            String sql = "UPDATE lecture SET name=?, date=?, videopath=?, docpath=?, chapterid=? WHERE id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getDate());
            ps.setString(3, dto.getVideopath());
            ps.setString(4, dto.getDocpath());
            ps.setString(5, dto.getChapterid());
            ps.setString(6, dto.getId());
            
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LectureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

    @Override
    public int delete(String id) {
        String sql="DELETE FROM lecture where id = " + id;
        System.out.println("SQL: " + sql);
        
        return XTData.runSQL(sql);
    }

    
}

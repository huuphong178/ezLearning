/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Comment;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lap11916
 */
public class CommentDAO extends ObjectDAO<Comment>{

    @Override
    public ArrayList<Comment> getAll() throws Exception{
        String sql="select * from comment";
        ArrayList<String[]> comments= new ArrayList<>(XTData.loadData(sql));
        ArrayList<Comment> result=new ArrayList<>();
        
        for(String[] row : comments){
            Comment comment = new Comment(row);
            result.add(comment);
        }
        return result;
    }

    @Override
    public Comment getOne(String id) throws Exception{
        String sql="select * from comment where id = " + id;
        ArrayList<String[]> comments= new ArrayList<>(XTData.loadData(sql));
        
        Comment item = null;
        if(!comments.isEmpty()){
            item = new Comment(comments.get(0));
        }
        
        return item;
    }

    @Override
    public int insert(Comment dto) throws Exception{
            String sql = "INSERT INTO comment(id, content, courseid, lectureid, parentid, userid, date) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getContent());
            ps.setString(3, dto.getCourseid());
            ps.setString(4, dto.getLectureid());
            ps.setString(5, dto.getParentid());
            ps.setString(6, dto.getUserid());
            ps.setString(7, dto.getDate());
            
            return ps.executeUpdate();
    }

    @Override
    public int update(String id, Comment dto) throws Exception{
            String sql = "UPDATE comment SET content=?, courseid=?, lectureid=?, parentid=?, userid=?, date=? WHERE id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getContent());
            ps.setString(2, dto.getCourseid());
            ps.setString(3, dto.getLectureid());
            ps.setString(4, dto.getParentid());
            ps.setString(5, dto.getUserid());
            ps.setString(6, dto.getDate());
            ps.setString(7, dto.getId());
            
            return ps.executeUpdate();
    }

    @Override
    public int delete(String id) throws Exception{
        String sql="DELETE FROM comment where id = " + id;
        System.out.println("SQL: " + sql);
        
        return XTData.runSQL(sql);
    }

    
}

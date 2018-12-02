/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Chapter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lap11916
 */
public class ChapterDAO extends ObjectDAO<Chapter>{

    @Override
    public ArrayList<Chapter> getAll() throws Exception{
        String sql="select * from chapter";
        ArrayList<String[]> chapters= new ArrayList<>(XTData.loadData(sql));
        ArrayList<Chapter> result=new ArrayList<>();
        
        for(String[] row : chapters){
            Chapter chapter = new Chapter(row);
            result.add(chapter);
        }
        return result;
    }

    @Override
    public Chapter getOne(String id) throws Exception{
        String sql="select * from chapter where id = " + id;
        ArrayList<String[]> chapters= new ArrayList<>(XTData.loadData(sql));
        
        Chapter item = null;
        if(!chapters.isEmpty()){
            item = new Chapter(chapters.get(0));
        }
        
        return item;
    }

    @Override
    public int insert(Chapter dto) throws Exception{
            String sql = "INSERT INTO chapter(id, courseid, name, chapter_order) VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getCourseid());
            ps.setString(3, dto.getName());
            ps.setString(4, String.valueOf(dto.getChapter_order()));
            
            return ps.executeUpdate();
    }

    @Override
    public int update(String id, Chapter dto) throws Exception{
            String sql = "UPDATE chapter SET courseid=?, name=?, chapter_order=? WHERE id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getCourseid());
            ps.setString(2, dto.getName());
            ps.setInt(3, dto.getChapter_order());
            ps.setString(4, dto.getId());
            
            return ps.executeUpdate();
    }

    @Override
    public int delete(String id) throws Exception{
        String sql="DELETE FROM chapter where id = " + id;
        System.out.println("SQL: " + sql);
        
        return XTData.runSQL(sql);
    }

    
}

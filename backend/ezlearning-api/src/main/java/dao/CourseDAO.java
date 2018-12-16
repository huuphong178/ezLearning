/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Course;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lap11916
 */
public class CourseDAO extends ObjectDAO<Course>{

    @Override
    public ArrayList<Course> getAll() throws Exception{
        String sql="select * from course";
        ArrayList<String[]> courses= new ArrayList<>(XTData.loadData(sql));
        ArrayList<Course> result=new ArrayList<>();
        
        for(String[] row : courses){
            Course course = new Course(row);
            result.add(course);
        }
        return result;
    }

    @Override
    public Course getOne(String id) throws Exception{
        String sql="select * from course where id = " + id;
        ArrayList<String[]> courses= new ArrayList<>(XTData.loadData(sql));
        
        Course item = null;
        if(!courses.isEmpty()){
            item = new Course(courses.get(0));
        }
        
        return item;
    }

    @Override
    public int insert(Course dto) throws Exception{
            String sql = "INSERT INTO course(id, name, rating, description, teacherid, price, date, cover, catid) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getName());
            ps.setString(3, String.valueOf(dto.getRating()));
            ps.setString(4, dto.getDescription());
            ps.setString(5, dto.getTeacherid());
            ps.setString(6, dto.getPrice());
            ps.setString(7, dto.getDate());
            ps.setString(8, dto.getCover());
            ps.setString(9, dto.getCatid());
            
            return ps.executeUpdate();
    }

    @Override
    public int update(String id, Course dto) throws Exception{
            String sql = "UPDATE course SET name=?, rating=?, description=?, teacherid=?, price=?, date=?, cover=?, catid=? WHERE id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, String.valueOf(dto.getRating()));
            ps.setString(3, dto.getDescription());
            ps.setString(4, dto.getTeacherid());
            ps.setString(5, dto.getPrice());
            ps.setString(6, dto.getDate());
            ps.setString(7, dto.getCover());
            ps.setString(8, dto.getCatid());
            ps.setString(9, id);
            
            return ps.executeUpdate();
    }

    @Override
    public int delete(String id) throws Exception{
        String sql="DELETE FROM course where id = " + id;
        System.out.println("SQL: " + sql);
        
        return XTData.runSQL(sql);
    }

    public ArrayList<String[]> executeSelectSQL(String sql) throws Exception{       
        return new ArrayList<>(XTData.loadData(sql));
    }
}

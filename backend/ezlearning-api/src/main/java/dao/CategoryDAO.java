/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Category;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lap11916
 */
public class CategoryDAO extends ObjectDAO<Category>{

    @Override
    public ArrayList<Category> getAll() throws SQLException {
        String sql="select * from category";
        ArrayList<String[]> carts= new ArrayList<>(XTData.loadData(sql));
        ArrayList<Category> result=new ArrayList<>();
        
        for(String[] row : carts){
            Category category = new Category(row);
            result.add(category);
        }
        return result;
    }

    @Override
    public Category getOne(String id) throws SQLException {
        String sql="select * from category where id = " + id;
        ArrayList<String[]> categories= new ArrayList<>(XTData.loadData(sql));
        
        Category item = null;
        if(!categories.isEmpty()){
            item = new Category(categories.get(0));
        }
        
        return item;
    }

    @Override
    public int insert(Category dto) throws Exception{
            String sql = "INSERT INTO category(id, name, color) VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getColor());
            
            return ps.executeUpdate();
    }

    @Override
    public int update(String id, Category dto) throws Exception {
            String sql = "UPDATE category SET name=?, color=? WHERE id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getColor());
            ps.setString(3, id);
            
            return ps.executeUpdate();
    }

    @Override
    public int delete(String id) throws Exception {
        String sql="DELETE FROM category where id = " + id;
        System.out.println("SQL: " + sql);
        
        return XTData.runSQL(sql);
    }

    
}

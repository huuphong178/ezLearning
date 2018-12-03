/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Cart;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author lap11916
 */
public class CartDAO extends ObjectDAO<Cart>{

    @Override
    public ArrayList<Cart> getAll() throws Exception{
        String sql="select * from cart";
        ArrayList<String[]> carts= new ArrayList<>(XTData.loadData(sql));
        ArrayList<Cart> result=new ArrayList<>();
        
        for(String[] row : carts){
            Cart cart=new Cart(row);
            result.add(cart);
        }
        return result;
    }
    
    public ArrayList<Cart> getByUserID(String userid) throws Exception{
        String sql="select * from cart where userid = '{{userid}}'";
        sql = sql.replace("{{userid}}", userid);
        ArrayList<String[]> carts= new ArrayList<>(XTData.loadData(sql));
        ArrayList<Cart> result=new ArrayList<>();
        
        for(String[] row : carts){
            Cart cart=new Cart(row);
            result.add(cart);
        }
        return result;
    }

    @Override
    public Cart getOne(String id) throws Exception{
        String sql="select * from cart where userid = '{{userid}}' AND courseid = {{courseid}}";
        sql = sql.replace("{{userid}}", id.split("\\|")[0]);
        sql = sql.replace("{{courseid}}", id.split("\\|")[1]);
        ArrayList<String[]> carts= new ArrayList<>(XTData.loadData(sql));
        
        Cart item = null;
        if(!carts.isEmpty()){
            item = new Cart(carts.get(0));
        }
        
        return item;
    }

    @Override
    public int insert(Cart dto) throws Exception{
            String sql = "INSERT INTO cart(userid, courseid, status) VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getUserid());
            ps.setString(2, dto.getCourseid());
            ps.setInt(3, dto.getStatus());
            
            return ps.executeUpdate();
    }

    @Override
    public int update(String id, Cart dto) throws Exception{
            String sql = "UPDATE cart SET status=? WHERE userid=? AND courseid=?";
            PreparedStatement ps = connection.prepareStatement(sql);    
            ps.setInt(1, dto.getStatus());
            ps.setString(2, id.split("\\|")[0]);
            ps.setString(3, id.split("\\|")[1]);
            
            return ps.executeUpdate();
    }

    @Override
    public int delete(String id) throws Exception{
        String sql="DELETE FROM cart where userid = '{{userid}}' AND courseid = {{courseid}}";
        sql = sql.replace("{{userid}}", id.split("\\|")[0]);
        sql = sql.replace("{{courseid}}", id.split("\\|")[1]);
        
        System.out.println("SQL: " + sql);
        
        return XTData.runSQL(sql);
    }

    
}

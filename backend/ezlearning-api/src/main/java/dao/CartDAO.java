/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Cart;
import java.util.ArrayList;

/**
 *
 * @author lap11916
 */
public class CartDAO extends ObjectDAO<Cart>{

    @Override
    public ArrayList<Cart> getAll() {
        String sql="select * from cart";
        ArrayList<String[]> carts= new ArrayList<>(XTData.loadData(sql));
        ArrayList<Cart> result=new ArrayList<>();
        
        for(String[] row : carts){
            Cart cart=new Cart(row);
            result.add(cart);
        }
        return result;
    }

    @Override
    public Cart getOne(String id) {
        String sql="select * from cart";
        ArrayList<String[]> carts= new ArrayList<>(XTData.loadData(sql));
        
        Cart item = null;
        if(!carts.isEmpty()){
            item = new Cart(carts.get(0));
        }
        
        return item;
    }

    @Override
    public int insert(Cart dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(String id, Cart dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

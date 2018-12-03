/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.CartDAO;
import dao.ObjectDAO;
import dto.Cart;
import java.util.ArrayList;

/**
 *
 * @author Phong Nguyen
 */
public class CartBUS extends ObjectBUS<Cart>{
    
    public CartBUS(ObjectDAO<Cart> dao) {
        super(dao);
    }
    
    public ArrayList<Cart> getByUserID(String id) throws Exception{
        if(!id.isEmpty())
            return ((CartDAO)dao).getByUserID(id);
        return null;
    }  
}

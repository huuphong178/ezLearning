/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import dto.Cart;

/**
 *
 * @author Phong Nguyen
 */
public class CartBUS extends ObjectBUS<Cart>{
    
    public CartBUS(ObjectDAO<Cart> dao) {
        super(dao);
    }
    
}

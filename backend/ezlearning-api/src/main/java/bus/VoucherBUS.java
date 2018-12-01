/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import dto.User;

/**
 *
 * @author Phong Nguyen
 */
public class VoucherBUS extends ObjectBUS<User>{
    
    public VoucherBUS(ObjectDAO<User> dao) {
        super(dao);
    }
    
}

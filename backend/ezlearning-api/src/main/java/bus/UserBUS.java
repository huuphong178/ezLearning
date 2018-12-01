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
public class UserBUS extends ObjectBUS<User>{
    
    public UserBUS(ObjectDAO<User> dao) {
        super(dao);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import dto.Method;

/**
 *
 * @author Phong Nguyen
 */
public class MethodBUS extends ObjectBUS<Method>{
    
    public MethodBUS(ObjectDAO<Method> dao) {
        super(dao);
    }
    
}

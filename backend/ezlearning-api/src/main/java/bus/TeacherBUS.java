/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import dto.Teacher;
import dto.Voucher;

/**
 *
 * @author Phong Nguyen
 */
public class TeacherBUS extends ObjectBUS<Teacher>{
    
    public TeacherBUS(ObjectDAO<Teacher> dao) {
        super(dao);
    }
    
}

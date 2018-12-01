/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import dto.Lecture;

/**
 *
 * @author Phong Nguyen
 */
public class LectureBUS extends ObjectBUS<Lecture>{
    
    public LectureBUS(ObjectDAO<Lecture> dao) {
        super(dao);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import dto.Rating;

/**
 *
 * @author Phong Nguyen
 */
public class RatingBUS extends ObjectBUS<Rating>{
    
    public RatingBUS(ObjectDAO<Rating> dao) {
        super(dao);
    }
    
}

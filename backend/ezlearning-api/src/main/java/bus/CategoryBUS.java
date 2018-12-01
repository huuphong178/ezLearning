/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import dto.Category;

/**
 *
 * @author Phong Nguyen
 */
public class CategoryBUS extends ObjectBUS<Category>{
    
    public CategoryBUS(ObjectDAO<Category> dao) {
        super(dao);
    }
    
}

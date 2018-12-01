/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import dto.Chapter;

/**
 *
 * @author Phong Nguyen
 */
public class ChapterBUS extends ObjectBUS<Chapter>{
    
    public ChapterBUS(ObjectDAO<Chapter> dao) {
        super(dao);
    }
    
}

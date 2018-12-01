/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import dto.Comment;

/**
 *
 * @author Phong Nguyen
 */
public class CommentBUS extends ObjectBUS<Comment>{
    
    public CommentBUS(ObjectDAO<Comment> dao) {
        super(dao);
    }
    
}

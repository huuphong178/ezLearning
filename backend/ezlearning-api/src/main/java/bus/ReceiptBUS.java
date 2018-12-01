/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import dto.Receipt;

/**
 *
 * @author Phong Nguyen
 */
public class ReceiptBUS extends ObjectBUS<Receipt>{
    
    public ReceiptBUS(ObjectDAO<Receipt> dao) {
        super(dao);
    }
    
}

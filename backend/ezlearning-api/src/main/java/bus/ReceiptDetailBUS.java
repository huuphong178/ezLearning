/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import dto.ReceiptDetail;

/**
 *
 * @author Phong Nguyen
 */
public class ReceiptDetailBUS extends ObjectBUS<ReceiptDetail>{
    
    public ReceiptDetailBUS(ObjectDAO<ReceiptDetail> dao) {
        super(dao);
    }
    
}

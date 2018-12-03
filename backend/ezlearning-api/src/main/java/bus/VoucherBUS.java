/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import dto.Voucher;

/**
 *
 * @author Phong Nguyen
 */
public class VoucherBUS extends ObjectBUS<Voucher>{
    
    public VoucherBUS(ObjectDAO<Voucher> dao) {
        super(dao);
    }
    
}

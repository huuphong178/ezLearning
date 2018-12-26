/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import com.google.gson.JsonArray;
import dao.ObjectDAO;
import dao.StudentDAO;
import dto.Student;
import dto.Voucher;
import java.sql.SQLException;

/**
 *
 * @author Phong Nguyen
 */
public class StudentBUS extends ObjectBUS<Student> {
    private StudentDAO studentdao=new StudentDAO();
    public StudentBUS(ObjectDAO<Student> dao) {
        super(dao);
    }

    public JsonArray getHistoryTransaction(String username) throws SQLException {
        return studentdao.getHistoryTransaction(username);
    }
}

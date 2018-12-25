/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dao.ObjectDAO;
import dao.UserDAO;
import dto.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Phong Nguyen
 */
public class UserBUS extends ObjectBUS<User> {

    public UserBUS(ObjectDAO<User> dao) {
        super(dao);
    }

    public User login(String username, String password) throws Exception {
        UserDAO userdao = new UserDAO();
        return userdao.login(username, password);
    }

    public JsonArray getTeacherBest(int n) throws Exception {
        UserDAO userdao = new UserDAO();
        return userdao.getTeacherBest(n);
    }

    public JsonObject thongkeCourseStudentTeacher() throws SQLException {
        UserDAO userdao = new UserDAO();
        return userdao.thongkeCourseStudentTeacher();
    }
}

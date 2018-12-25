/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import dao.UserDAO;
import dto.User;
import java.util.ArrayList;

/**
 *
 * @author Phong Nguyen
 */
public class UserBUS extends ObjectBUS<User>{
    public UserBUS(ObjectDAO<User> dao) {
        super(dao);
    }
    public User login(String username, String password) throws Exception{
        UserDAO userdao=new UserDAO();
        return userdao.login(username, password);
    }
    public ArrayList<User> getTeacherBest(int n) throws Exception{
        UserDAO userdao=new UserDAO();
        return userdao.getTeacherBest(n);
    }
}

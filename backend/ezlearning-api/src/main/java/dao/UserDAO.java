/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.User;
import java.util.ArrayList;

/**
 *
 * @author Phong Nguyen
 */
public class UserDAO {
  
    dataAccess XTData=dataAccess.getInstance();
    public ArrayList<User> getAll(){
        String sql="select * from user";
        ArrayList<String[]> users= new ArrayList<>(XTData.loadData(sql));
        ArrayList<User> result=new ArrayList<>();
        for(String[] row:users){
            User user=new User(row);
            result.add(user);
        }
        return result;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import dao.UserDAO;
import dao.dataAccess;
import dao.dataAccess1;
import dto.User;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phong Nguyen
 */
public class manTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          UserDAO userdao=new UserDAO();
         ArrayList<User> list = userdao.getAll();
        //list=xtdata.loadData("select * from user");
        System.out.println();
    }
    
}

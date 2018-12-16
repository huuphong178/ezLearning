/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Phong Nguyen
 */
public class Teacher extends User{
    
    public Teacher(String[] user) {
        super(user);
    }
     public Teacher(String username, String password, String email, int role, String displayname, String address, String phone, String degree, String dob, String avatar) {
        super(username, password, email, role, displayname, address, phone, degree, dob, avatar);
    }
}

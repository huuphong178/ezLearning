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
public class Student extends User{
    
    public Student(String[] user) {
        super(user);
    }
    public Student(String username, String password, String email, int role, String displayname, String address, String phone, String degree, String dob, String avatar) {
        super(username, password, email, role, displayname, address, phone, degree, dob, avatar);
    }

    @Override
    public int getRole() {
        return 3; //To change body of generated methods, choose Tools | Templates.
    }
    
}

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
public class Student extends User {

    private int countCourse;

    public Student(String[] user) {
        super(user);
        this.countCourse = Integer.parseInt(user[10]);
        this.role = 3;
    }

    public Student(String username, String password, String email, int role, String displayname, String address, String phone, String degree, String dob, String avatar, int countCourse) {
        super(username, password, email, role, displayname, address, phone, degree, dob, avatar);
        this.countCourse = countCourse;
    }

    @Override
    public int getRole() {
        return 3; //To change body of generated methods, choose Tools | Templates.
    }

}

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
public class Teacher extends User {
    private int countCourse;
    public Teacher(String[] user) {
        super(user);
        this.countCourse = Integer.parseInt(user[10]);
        this.role = 2;
    }

    public Teacher(String username, String password, String email, int role, String displayname, String address, String phone, String degree, String dob, String avatar, int countCourse) {
        super(username, password, email, role, displayname, address, phone, degree, dob, avatar);
        this.countCourse=countCourse;
    }

    public int getCountCourse() {
        return countCourse;
    }

    public void setCountCourse(int countCourse) {
        this.countCourse = countCourse;
    }

    @Override
    public int getRole() {
        return 2; //To change body of generated methods, choose Tools | Templates.
    }

}

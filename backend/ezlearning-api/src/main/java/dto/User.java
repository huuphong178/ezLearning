/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import util.DateUtil;

/**
 *
 * @author Phong Nguyen
 */
public class User {

    String username;
    String password;
    String email;
    int role;
    String displayname;
    String address;
    String phone;
    String degree;
    String dob;
    String avatar;

    public User(String[] user) {
        this.username = user[0];
        this.password = user[1];
        this.email = user[2];
        this.role = Integer.parseInt(user[3]);
        this.displayname = user[4];
        this.address = user[5];
        this.phone = user[6];
        this.degree = user[7];
        this.dob =user[8];
        this.avatar = user[8];

    }

    

    public User(String username, String password, String email, int role, String displayname, String address, String phone, String degree, String dob) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.displayname = displayname;
        this.address = address;
        this.phone = phone;
        this.degree = degree;
        this.dob = dob;
        //this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
}

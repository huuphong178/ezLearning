/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author lap11916
 */
public class PopularCourse {
    private String courseid;
    private String coursename;
    private String price;
    private String username;
    private String avatar;
    private String rating;
    private String catid;
    private String catname;
    private String quality;
    private String teachername;

    public PopularCourse(String[] row) {
        this.courseid = row[0];
        this.coursename = row[1];
        this.price = row[2];
        this.username = row[3];
        this.avatar = row[4];
        this.rating = row[5];
        this.catid = row[6];
        this.catname = row[7];
        this.quality = row[8];
        this.teachername = row[9];
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
    
    
    
}

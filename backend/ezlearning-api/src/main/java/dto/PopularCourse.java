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
    private String courseName;
    private String price;
    private String userName;
    private String avatar;
    private String rating;
    private String catid;
    private String catName;
    private String quality;
    private String teacherName;
    private String description;
    private String percentage;
    private String promotionalPrice;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PopularCourse(String[] row) {
        this.courseid = row[0];
        this.courseName = row[1];
        this.price = row[2];
        this.userName = row[3];
        this.avatar = row[4];
        this.rating = row[5];
        this.catid = row[6];
        this.catName = row[7];
        this.quality = row[8];
        this.teacherName = row[9];
        this.description = row[10];
        this.percentage = row[18];
        
        Long price = Long.parseLong(this.price);
        Long percentage = Long.parseLong(this.percentage);
        Long sale = (price * percentage) / 100;
        Long kq = price-sale;
        this.promotionalPrice = kq.toString();
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return courseName;
    }

    public void setCoursename(String coursename) {
        this.courseName = coursename;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
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
        return catName;
    }

    public void setCatname(String catname) {
        this.catName = catname;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
    
    
    
}

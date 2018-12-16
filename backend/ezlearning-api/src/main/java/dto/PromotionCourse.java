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
public class PromotionCourse {
    private String id;
    private String name;
    private String rating;
    private String price;
    private String catid;
    private String catName;
    private String teacherName;
    private String avatar;
    private String percentage;
    private String from_date;
    private String to_date;
    private String promotionalPrice;
    
    public PromotionCourse(String[] row) {
        this.id = row[0];
        this.name = row[1];
        this.rating = row[2];
        this.price = row[3];
        this.catid = row[4];
        this.catName = row[5];
        this.teacherName = row[6];
        this.avatar = row[7];
        this.percentage = row[8];
        this.from_date = row[9];
        this.to_date = row[10];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(String promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }
    
    
    
}

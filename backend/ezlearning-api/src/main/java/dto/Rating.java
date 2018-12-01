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
public class Rating {

    private String id;
    private String courseid;
    private int race;
    private String userid;
    private String date;
     public Rating(String[] rating) {
        this.id = rating[0];
        this.courseid = rating[1];
        this.race = Integer.parseInt(rating[2]);
        this.userid = rating[3];
        this.date = rating[4];
    }

    public Rating(String id, String courseid, int race, String userid, String date) {
        this.id = id;
        this.courseid = courseid;
        this.race = race;
        this.userid = userid;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
     
}

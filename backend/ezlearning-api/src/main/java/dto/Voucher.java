/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author Phong Nguyen
 */
public class Voucher {

    private String id;
    private String name;
    private String code;
    private String from;
    private String to;
    private int percentage;
    private String courseid;

    public Voucher(String[] voucher) {
        this.id = voucher[0];
        this.name = voucher[1];
        this.code = voucher[2];
        this.from = voucher[3];
        this.to = voucher[4];
        this.percentage = Integer.parseInt(voucher[5]);
        this.courseid = voucher[6];
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

}

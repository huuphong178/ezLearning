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
public class Receipt {

    private String id;
    private String address;
    private String studentid;
    private Long total;
    private String date;
    private int method;
     public Receipt(String[] receipt) {
        this.id = receipt[0];
        this.address = receipt[1];
        this.studentid = receipt[2];
        this.total = Long.parseLong(receipt[3]);
        this.date = receipt[4];
        this.method = Integer.parseInt(receipt[5]);
    }

    public Receipt(String id, String address, String studentid, Long total, String date, int method) {
        this.id = id;
        this.address = address;
        this.studentid = studentid;
        this.total = total;
        this.date = date;
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }
     
}

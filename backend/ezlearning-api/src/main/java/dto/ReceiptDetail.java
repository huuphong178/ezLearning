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
public class ReceiptDetail {

    private String id;
    private String receiptid;
    private String studentid;
    private String courseid;
    private String voucherid;
    private int status;
    private String code;
    public ReceiptDetail(String[] receiptdetail) {
        this.id = receiptdetail[0];
        this.receiptid = receiptdetail[1];
        this.studentid = receiptdetail[2];
        this.courseid = receiptdetail[3];
        this.voucherid = receiptdetail[4];
        this.status = Integer.parseInt(receiptdetail[5]);
        this.code = receiptdetail[6];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReceiptid() {
        return receiptid;
    }

    public void setReceiptid(String receiptid) {
        this.receiptid = receiptid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getVoucherid() {
        return voucherid;
    }

    public void setVoucherid(String voucherid) {
        this.voucherid = voucherid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}

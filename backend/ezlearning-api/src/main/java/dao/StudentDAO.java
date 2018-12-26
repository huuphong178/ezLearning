/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dto.Student;
import dto.User;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Phong Nguyen
 */
public class StudentDAO extends ObjectDAO<Student> {

    @Override
    public ArrayList<Student> getAll() throws Exception {
        String sql = "SELECT student.*,IFNULL(countCourse,0) as 'countCourse'\n"
                + "from (SELECT * FROM `user` where role=3) as student\n"
                + "LEFT JOIN  (select studentid, COUNT(id) as 'countCourse'\n"
                + "from receiptdetail GROUP BY studentid) as countCourse2\n"
                + "on student.username=countCourse2.studentid";
        ArrayList<String[]> users = new ArrayList<>(XTData.loadData(sql));
        ArrayList<Student> result = new ArrayList<>();
        for (String[] row : users) {
            Student user = new Student(row);
            result.add(user);
        }
        return result;
    }

    @Override
    public Student getOne(String username) throws Exception {
        String sql = "SELECT student.*,IFNULL(countCourse,0) as 'countCourse'\n"
                + "from (SELECT * FROM `user` where role=3) as student\n"
                + "LEFT JOIN  (select studentid, COUNT(id) as 'countCourse'\n"
                + "from receiptdetail GROUP BY studentid) as countCourse2\n"
                + "on student.username=countCourse2.studentid\n"
                + "where username='" + username + "'";
        ArrayList<String[]> users = new ArrayList<>(XTData.loadData(sql));
        Student item = null;
        if (!users.isEmpty()) {
            item = new Student(users.get(0));
        }
        return item;
    }

    public JsonArray getHistoryTransaction(String username) throws SQLException {
        JsonArray list = new JsonArray();
        String sql = "SELECT receipt.id as 'cartid', receipt.date, course.name as 'coursename', course.price as 'money',\n"
                + "voucher.percentage as 'discount', `user`.displayname as 'teachername', `user`.avatar as 'avatarteacher' \n"
                + "from receiptdetail, receipt, course, voucher,user where receiptdetail.receiptid=receipt.id \n"
                + "and receiptdetail.courseid=course.id and receiptdetail.voucherid=voucher.id \n"
                + "and course.teacherid=`user`.username and receiptdetail.studentid='"+username+"'";
        ArrayList<String[]> arraylist = new ArrayList<>(XTData.loadData(sql));
        for (String[] row : arraylist) {
            JsonObject object = new JsonObject();
            object.addProperty("cartid", row[0]);
            object.addProperty("date", row[1]);
            object.addProperty("coursename", row[2]);
            object.addProperty("money", row[3]);
            object.addProperty("discount", row[4]);
            object.addProperty("teachername", row[5]);
            object.addProperty("avatarteacher", row[6]);
            list.add(object);
        }
        return list;
    }

    @Override
    public int insert(Student dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(String id, Student dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

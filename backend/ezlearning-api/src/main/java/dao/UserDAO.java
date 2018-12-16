/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Teacher;
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
public class UserDAO extends ObjectDAO<User> {

    @Override
    public ArrayList<User> getAll() throws Exception {
        String sql = "select * from user";
        ArrayList<String[]> users = new ArrayList<>(XTData.loadData(sql));
        ArrayList<User> result = new ArrayList<>();
        for (String[] row : users) {
            User user = new User(row);
            result.add(user);
        }
        return result;
    }

    @Override
    public User getOne(String username) throws Exception {
        String sql = "select * from user where username='" + username + "'";
        User item = null;
        ArrayList<String[]> users = new ArrayList<>(XTData.loadData(sql));
        if (!users.isEmpty()) {
            item = new User(users.get(0));
        }
        return item;
    }

    public User login(String username, String password) throws Exception {
        String sql = "select * from user where username='" + username + "'and password ='" + password + "'";
        User item = null;
        ArrayList<String[]> users = new ArrayList<>(XTData.loadData(sql));
        if (!users.isEmpty()) {
            item = new User(users.get(0));
        }
        return item;
    }

    @Override
    public int insert(User dto) throws Exception {
        String sql = "Insert Into user(username, password, email, role , displayname, address, phone, degree, dob, avatar) Values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        byte[] avatar = ConverImageURL(dto.getAvatar());
        ps.setString(1, dto.getUsername());
        ps.setString(2, dto.getPassword());
        ps.setString(3, dto.getEmail());
        ps.setInt(4, dto.getRole());
        ps.setString(5, dto.getDisplayname());
        ps.setString(6, dto.getAddress());
        ps.setString(7, dto.getPhone());
        ps.setString(8, dto.getDegree());
        ps.setString(9, dto.getDob());
        ps.setBytes(10, avatar);
        return ps.executeUpdate();
    }

    @Override
    public int update(String username, User dto) throws Exception {
        String sql = "update user set password =?, email = ? , role = ?, displayname =?, address=?, phone=?, degree=?, dob=? where username =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, dto.getPassword());
        ps.setString(2, dto.getEmail());
        ps.setInt(3, dto.getRole());
        ps.setString(4, dto.getDisplayname());
        ps.setString(5, dto.getAddress());
        ps.setString(6, dto.getPhone());
        ps.setString(7, dto.getDegree());
        ps.setString(8, dto.getDob());
        ps.setString(9, username);
        return ps.executeUpdate();
    }

    @Override
    public int delete(String username) throws Exception {
        String sql = "delete from user where username='" + username + "'";
        return XTData.runSQL(sql);
    }

    public ArrayList<User> getTeacherBest(int n) throws Exception {
        String sql = "SELECT u.*, AVG(c.rating) as 'rate' from course c, `user` u\n"
                + "where u.username=c.teacherid \n"
                + "GROUP BY c.teacherid \n"
                + "ORDER BY rate DESC\n"
                + "LIMIT " + n;
        ArrayList<String[]> users = new ArrayList<>(XTData.loadData(sql));
        ArrayList<User> result = new ArrayList<>();
        for (String[] row : users) {
            User teacher = new Teacher(row);
            result.add(teacher);
        }
        return result;
    }

    private byte[] ConverFile(String filepathlocal) {
        FileInputStream fileinputstream = null;
        File file = new File(filepathlocal);
        byte[] bFile = new byte[(int) file.length()];
        try {
            fileinputstream = new FileInputStream(file);
            fileinputstream.read(bFile);
            fileinputstream.close();

        } catch (IOException e) {
            bFile = null;
        }
        return bFile;
    }

    private byte[] ConverImageURL(String url_image) {
        try {
            URL url = new URL(url_image);
            Image image = ImageIO.read(url);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage) image, "jpg", output);
            byte[] avatar = output.toByteArray();
            System.err.println(avatar.length);
            return avatar;
        } catch (MalformedURLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}

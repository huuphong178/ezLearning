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
public class TeacherDAO extends ObjectDAO<Teacher> {

    @Override
    public ArrayList<Teacher> getAll() throws Exception {
        String sql = "SELECT teacher.*,IFNULL(countCourse,0) as 'countCourse'\n"
                + "from (SELECT * FROM `user` where role=2) as teacher\n"
                + "LEFT JOIN  (select teacherid, COUNT(id) as 'countCourse'\n"
                + "from course GROUP BY teacherid) as countCourse2\n"
                + "on teacher.username=countCourse2.teacherid";
        ArrayList<String[]> users = new ArrayList<>(XTData.loadData(sql));
        ArrayList<Teacher> result = new ArrayList<>();
        for (String[] row : users) {
            Teacher user = new Teacher(row);
            result.add(user);
        }
        return result;
    }

    @Override
    public Teacher getOne(String username) throws Exception {
        String sql = "SELECT teacher.*,IFNULL(countCourse,0) as 'countCourse'\n"
                + "from (SELECT * FROM `user` where role=2) as teacher\n"
                + "LEFT JOIN  (select teacherid, COUNT(id) as 'countCourse'\n"
                + "from course GROUP BY teacherid) as countCourse2\n"
                + "on teacher.username=countCourse2.teacherid\n"
                + "where username='" + username + "'";
        ArrayList<String[]> users = new ArrayList<>(XTData.loadData(sql));
        Teacher item = null;
        if (!users.isEmpty()) {
            item = new Teacher(users.get(0));
        }
        return item;
    }

    @Override
    public int insert(Teacher dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(String id, Teacher dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

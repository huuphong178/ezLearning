/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.CourseDAO;
import dao.ObjectDAO;
import dto.Course;
import java.util.ArrayList;

/**
 *
 * @author Phong Nguyen
 */
public class CourseBUS extends ObjectBUS<Course>{
    
    public CourseBUS(ObjectDAO<Course> dao) {
        super(dao);
    }
    
    public ArrayList<String[]> executeSelectSQL(String sql) throws Exception{   
        return ((CourseDAO)dao).executeSelectSQL(sql);
    }
}

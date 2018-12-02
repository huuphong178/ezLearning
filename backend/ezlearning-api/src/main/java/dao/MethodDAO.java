/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phong Nguyen
 */
public class MethodDAO extends ObjectDAO<Method> {

    @Override
    public ArrayList<Method> getAll() throws Exception{
        String sql = "select * from method";
        ArrayList<String[]> methods = new ArrayList<>(XTData.loadData(sql));
        ArrayList<Method> result = new ArrayList<>();
        for (String[] row : methods) {
            Method method = new Method(row);
            result.add(method);
        }
        return result;
    }

    @Override
    public Method getOne(String id) throws Exception{
        String sql = "select * from method where id=" + id;
        Method item = null;
        ArrayList<String[]> methods = new ArrayList<>(XTData.loadData(sql));
        if (!methods.isEmpty()) {
            item = new Method(methods.get(0));
        }
        return item;
    }

    @Override
    public int insert(Method dto) throws Exception{
            String sql = "Insert Into method(id, name) Values(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getName());
            return ps.executeUpdate();
    }

    @Override
    public int update(String id, Method dto) throws Exception{
            String sql = "update method set name =? where id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, id);
            return ps.executeUpdate();
    }

    @Override
    public int delete(String id) throws Exception{
        String sql = "delete from method where id=" + id;
        return XTData.runSQL(sql);
    }
}

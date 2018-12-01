/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.User;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author lap11916
 * @param <T>
 */
public abstract class ObjectDAO<T extends Object> {
    
    protected dataAccess XTData = dataAccess.getInstance();
    protected Connection connection = dataAccess.getConnect();
    
    public abstract ArrayList<T> getAll();
    public abstract T getOne(String id);
    public abstract int insert(T dto);
    public abstract int update(String id, T dto);
    public abstract int delete(String id);
}

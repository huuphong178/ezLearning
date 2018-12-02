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
    protected Connection connection = XTData.connection;
    public abstract ArrayList<T> getAll() throws Exception;
    public abstract T getOne(String id) throws Exception;
    public abstract int insert(T dto) throws Exception;
    public abstract int update(String id, T dto) throws Exception;
    public abstract int delete(String id) throws Exception;
}

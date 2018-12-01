/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.ObjectDAO;
import java.util.ArrayList;

/**
 *
 * @author Phong Nguyen
 */
public abstract class ObjectBUS<T> {
    private ObjectDAO<T> dao;

    public ObjectBUS(ObjectDAO<T> dao) {
        this.dao=dao;
    }
    public ArrayList<T> getAll(){
        return dao.getAll();
    }
    public T getOne(String id){
        if(!id.isEmpty())
            return dao.getOne(id);
        return null;
    }   
    public int insert(T dto){
        if(dto!=null)
            return dao.insert(dto);
        return 0;
    }
    public int update(String id, T dto){
        if(dto!=null && !id.isEmpty())
            return dao.update(id,dto);
        return 0;
    }
    public int delete(String id){
        if(!id.isEmpty())
            return dao.delete(id);
        return 0;
    }
}

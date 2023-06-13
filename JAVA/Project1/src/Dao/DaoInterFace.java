/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
//data access object inter face
public interface DaoInterFace<T> {
    public int insert(T t);
    public int update(T t);
    public int delete();
    public ArrayList<T> selectAll();
    public T selectById(T t);
    public ArrayList<T> selectByCondition(String condition);
    
}

package ru.itis.dao;

import java.util.List;

/**
 * 11.10.2017
 * BaseDao
 *
 * @author Victoria Noumenko
 * @version v1.0
 */

public interface BaseDao<T> {
    List<T> findAll();
    T find(int id);
    int save(T model);
    void update(T model);
    void delete(int id);
}

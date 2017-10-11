package ru.itis.dao;

import ru.itis.models.User;

import java.util.List;

/**
 * 11.10.2017
 * UsersDao
 *
 * @author Victoria Noumenko
 * @version v1.0
 */

public interface UsersDao extends BaseDao<User> {
    List<User> findUsersByAge(int age);
    List<User> findUsersByNameAndAge(String name, int age);
}

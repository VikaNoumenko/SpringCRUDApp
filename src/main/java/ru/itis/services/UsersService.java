package ru.itis.services;

import ru.itis.models.User;

import java.util.List;

/**
 * 11.10.2017
 * UsersService
 *
 * @author Victoria Noumenko
 * @version v1.0
 */

public interface UsersService {
    void register(User user);
    List<User> getAllUsersByAge(int age);
    List<User> getAll();
    List<User> getAllUsersByNameAndAge(String name, int age);
}

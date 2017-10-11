package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dao.UsersDao;
import ru.itis.models.User;

import java.util.List;

/**
 * 11.10.2017
 * UsersServiceImpl
 *
 * @author Victoria Noumenko
 * @version v1.0
 */

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public void register(User user) {
        usersDao.save(user);
    }

    @Override
    public List<User> getAllUsersByAge(int age) {
        return usersDao.findUsersByAge(age);
    }

    @Override
    public List<User> getAll() {
        return usersDao.findAll();
    }

    @Override
    public List<User> getAllUsersByNameAndAge(String name, int age) {
        return usersDao.findUsersByNameAndAge(name, age);
    }
}

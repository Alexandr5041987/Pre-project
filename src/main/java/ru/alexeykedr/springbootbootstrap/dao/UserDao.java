package ru.alexeykedr.springbootbootstrap.dao;

import ru.alexeykedr.springbootbootstrap.model.User;
import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    User getUserByUsername(String username);

    User getUserById(long id);
}
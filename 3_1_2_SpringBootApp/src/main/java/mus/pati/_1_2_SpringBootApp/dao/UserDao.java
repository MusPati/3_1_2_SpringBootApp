package mus.pati._1_2_SpringBootApp.dao;


import mus.pati._1_2_SpringBootApp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void saveUser(User user);

    void deleteUser(long id);

    void updateUser(User user);

    List<User> getAllUsers();

    Optional<User> showUserById(long id);

    void updateUserInfo(int id, User user);
}

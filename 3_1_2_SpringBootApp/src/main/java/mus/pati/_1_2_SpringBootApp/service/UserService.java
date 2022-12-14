package mus.pati._1_2_SpringBootApp.service;


import mus.pati._1_2_SpringBootApp.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void deleteUser(long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User showUserById(long id);

    void updateUserInfo(int id, User user);
}

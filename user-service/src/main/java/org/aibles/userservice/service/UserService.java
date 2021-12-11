package org.aibles.userservice.service;

import org.aibles.userservice.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    User createUser(User user);

    User updateUser(User user, int id);

    User deleteUserById(int id);
}

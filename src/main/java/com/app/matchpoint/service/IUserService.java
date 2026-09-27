package com.app.matchpoint.service;

import com.app.matchpoint.model.User;

import java.util.List;

public interface IUserService {

    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User user);

    boolean deleteUser(Long id);
}

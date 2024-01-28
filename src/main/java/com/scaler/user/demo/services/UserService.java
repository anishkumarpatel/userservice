package com.scaler.user.demo.services;

import com.scaler.user.demo.exceptions.UserNotFoundException;
import com.scaler.user.demo.models.User;

import java.util.List;

public interface UserService {
    public User addNewUser(User user);

    public User updateUser(Long id, User user) throws UserNotFoundException;

    public User replaceUser(Long id, User user) throws UserNotFoundException;

    public String deleteUser(Long id) throws UserNotFoundException;

    public String login(String username, String password) throws UserNotFoundException;

    public User getSingleUser(Long id) throws UserNotFoundException;

    public List<User> getAllUsers();
}

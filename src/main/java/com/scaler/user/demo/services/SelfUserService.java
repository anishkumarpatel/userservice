package com.scaler.user.demo.services;

import com.scaler.user.demo.exceptions.UserNotFoundException;
import com.scaler.user.demo.models.User;
import com.scaler.user.demo.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfUserService implements UserService {
    private UserRepository userRepository;

    @Autowired
    public SelfUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public User addNewUser(User user) {
        User user1 = userRepository.save(user);
        return user1;
    }

    @Override
    public User updateUser(Long id, User user) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User with id: " + id + " doesn't exist.");
        }
        User existingUser = userOptional.get();

        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getUsername() != null) {
            existingUser.setUsername(user.getUsername());
        }
        if (user.getPassword() != null) {
            existingUser.setPassword(user.getPassword());
        }
        if (user.getFirstName() != null) {
            existingUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            existingUser.setLastName(user.getLastName());
        }
        if (user.getCity() != null) {
            existingUser.setCity(user.getCity());
        }
        if (user.getStreet() != null) {
            existingUser.setStreet(user.getStreet());
        }
        if (user.getNumber() != null) {
            existingUser.setNumber(user.getNumber());
        }
        if (user.getZipcode() != null) {
            existingUser.setZipcode(user.getZipcode());
        }
        if (user.getLatitude() != null) {
            existingUser.setLatitude(user.getLatitude());
        }
        if (user.getLongitude() != null) {
            existingUser.setLongitude(user.getLongitude());
        }
        if (user.getPhone() != null) {
            existingUser.setPhone(user.getPhone());
        }

        return userRepository.save(existingUser);
    }

    @Override
    public User replaceUser(Long id, User user) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User with id: " + id + " doesn't exist.");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Long id) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User with id: " + id + " doesn't exist.");
        }

        userRepository.deleteById(id);
        return "User with id: " + id + " is deleted from the database.";
    }

    @Override
    public String login(String username, String password) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findByUsernameAndPassword(username, password);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("Incorrect Username and Password combination. Try again.");
        }

        return "Login for username: " + username + " is successful.";
    }

    @Override
    public User getSingleUser(Long id) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User with id: " + id + " doesn't exist.");
        }
        return userOptional.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

package com.scaler.user.demo.controllers;

import com.scaler.user.demo.dtos.MessageDto;
import com.scaler.user.demo.exceptions.UserNotFoundException;
import com.scaler.user.demo.models.User;
import com.scaler.user.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getSingleUser(@PathVariable("id") Long id) throws UserNotFoundException {
        return userService.getSingleUser(id);
    }

    @PostMapping()
    public User addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @PatchMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) throws UserNotFoundException {

        return userService.updateUser(id, user);
    }

    @PutMapping("/{id}")
    public User replaceUser(@PathVariable("id") Long id, @RequestBody User user) throws UserNotFoundException {
        return userService.replaceUser(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deleteUser(@PathVariable("id") Long id) throws UserNotFoundException {
        MessageDto messageDto = new MessageDto();
        messageDto.setMessage(userService.deleteUser(id));
        return new ResponseEntity<MessageDto>(messageDto, HttpStatus.OK);
    }

    @GetMapping("/{username}/{password}")
    public String login(@PathVariable("username") String username, @PathVariable("password") String password) throws UserNotFoundException {
        return userService.login(username, password);
    }
}

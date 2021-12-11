package org.aibles.userservice.controller;

import org.aibles.userservice.model.User;
import org.aibles.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getUsers() {
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping() //cứ call post là 200-201
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    //truyền ID lên backend -> vào db để check[tồn tại 200, k tồn tại 404 not found], còn 400 check validate?
    public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody User userUpdated) {
        return new ResponseEntity<>(userService.updateUser(userUpdated, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        User deleteUser = userService.deleteUserById(id);
        return new ResponseEntity<>(deleteUser, HttpStatus.OK);
    }
}
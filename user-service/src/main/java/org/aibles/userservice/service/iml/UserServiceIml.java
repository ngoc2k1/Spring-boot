package org.aibles.userservice.service.iml;

import org.aibles.userservice.model.User;
import org.aibles.userservice.repository.UserRepository;
import org.aibles.userservice.service.UserService;
import org.aibles.userservice.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIml implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceIml(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException();
        } else {
            return user;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
//        khi id chưa được auto_increment
//        User createdUser = userRepository.findById(user.getId()).orElse(null);
//        if (createdUser != null) {
//            throw new NotFoundException();
//        } else return userRepository.save(user);
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    @Override
    public User updateUser(User user, int id) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            throw new NotFoundException();
        } else {
            existingUser.setAge(user.getAge());
            existingUser.setName(user.getName());
            User updateUser = userRepository.save(existingUser);
            return updateUser;
        }
    }

    @Override
    public void deleteUserById(int id) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            throw new NotFoundException();
        } else {
            userRepository.delete(existingUser);
        }
    }
}




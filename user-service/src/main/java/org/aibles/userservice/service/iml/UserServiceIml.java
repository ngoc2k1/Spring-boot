package org.aibles.userservice.service.iml;

import org.aibles.userservice.model.User;
import org.aibles.userservice.repository.UserRepository;
import org.aibles.userservice.service.UserService;
import org.aibles.userservice.service.exception.NotFoundException;
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
        List<User> userList = userRepository.findAll();
        if (userList == null) {
            throw new NotFoundException();
        } else {
            return userList;
        }
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
        User updateUser = userRepository.findById(id).orElse(null);
        if (updateUser == null) {
            throw new NotFoundException();
        } else {
            updateUser.setAge(user.getAge());
            updateUser.setName(user.getName());
            userRepository.save(updateUser);
            return updateUser;
        }
    }

    @Override
    public User deleteUserById(int id) {
        if (userRepository.findById(id) == null) {
            throw new NotFoundException();
        } else {
            User deletedUser = userRepository.getById(id);
            userRepository.deleteById(id);
            return deletedUser;
        }
    }
}




package com.example.users.service;


import com.example.users.entity.User;
import com.example.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public User updateUserById(Long id, User user) {
        Optional<User> user1 = userRepository.findById(id);

        if (user1.isPresent()) {
            User originalUser = user1.get();

            if (Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) {
                originalUser.setUserName(user.getUserName());
            }
            if (Objects.nonNull(user.getUserSalary()) && user.getUserSalary() != 0) {
                originalUser.setUserSalary(user.getUserSalary());
            }
            return userRepository.save(originalUser);
        }
        return null;
    }

    @Override
    public String deleteUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "No such user in the database";
    }
}

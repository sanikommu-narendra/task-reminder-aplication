package com.narendra.services;

import com.narendra.dto.User;
import com.narendra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(int userId) {
        return userRepository.findById(userId).get();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}

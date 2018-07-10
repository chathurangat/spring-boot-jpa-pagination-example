package com.springbootdev.examples.jpa.examples.service.impl;

import com.springbootdev.examples.jpa.examples.model.User;
import com.springbootdev.examples.jpa.examples.repository.UserRepository;
import com.springbootdev.examples.jpa.examples.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> findUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}

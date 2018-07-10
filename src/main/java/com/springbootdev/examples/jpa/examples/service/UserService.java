package com.springbootdev.examples.jpa.examples.service;

import com.springbootdev.examples.jpa.examples.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User create(User user);

    Page<User> findUsers(Pageable pageable);
}

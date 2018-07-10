package com.springbootdev.examples.jpa.examples.controller;

import com.springbootdev.examples.jpa.examples.dto.response.user.UserResponse;
import com.springbootdev.examples.jpa.examples.model.User;
import com.springbootdev.examples.jpa.examples.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public Map<String, Object> createUsers(@RequestBody User user) {
        int numOfRecords = 100;
        String name = user.getName();
        //creating 100 sample users
        for (int index = 1; index <= numOfRecords; index++) {
            User userNew = new User();
            userNew.setName(name + " " + index);
            userService.create(userNew);
        }

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("num_users_added", numOfRecords);
        return response;
    }


    @GetMapping("/users")
    public UserResponse getUsers(Pageable pageable)
    {
        Page page = userService.findUsers(pageable);
        return new UserResponse(page);
    }


    @GetMapping("/users2")
    public UserResponse getUsers2()
    {
        int pageNumber = 3;
        int pageSize = 2;

        Page page = userService.findUsers(PageRequest.of(pageNumber, pageSize));
        return new UserResponse(page);
    }
}

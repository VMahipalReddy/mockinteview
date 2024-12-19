package com.mockinteriew.mock_interview.controller;

import com.mockinteriew.mock_interview.model.User;
import com.mockinteriew.mock_interview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.getUser(email);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//        return "Hello";
    }
}

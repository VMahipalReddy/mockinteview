package com.mockinteriew.mock_interview.service;

import com.mockinteriew.mock_interview.model.User;
import com.mockinteriew.mock_interview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getUser(String email){
        return userRepository.findByEmail(email);
    }
}

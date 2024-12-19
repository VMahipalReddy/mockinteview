package com.mockinteriew.mock_interview.service;

import com.mockinteriew.mock_interview.model.User;
import com.mockinteriew.mock_interview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllCandidates() {
        return userRepository.findAll();
    }

    public User getCandidateByEmail(String email) {
        Optional<User> candidate = userRepository.findByEmail(email);
        return candidate.orElse(null);
    }

    public User createCandidate(User candidate) {
        return userRepository.save(candidate);
    }

    public User updateCandidate(String email, User candidateDetails) {
        Optional<User> candidateOptional = userRepository.findByEmail(email);
        if (candidateOptional.isPresent()) {
            User candidate = candidateOptional.get();
            candidate.setName(candidateDetails.getName());
            candidate.setEmail(candidateDetails.getEmail());
            // Update other fields as necessary
            return userRepository.save(candidate);
        } else {
            return null;
        }
    }

    public boolean deleteCandidate(String email) {
        Optional<User> candidateOptional = userRepository.findByEmail(email);
        if (candidateOptional.isPresent()) {
            userRepository.delete(candidateOptional.get());
            return true;
        } else {
            return false;
        }
    }
}

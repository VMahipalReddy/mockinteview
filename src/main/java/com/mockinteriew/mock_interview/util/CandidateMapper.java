package com.mockinteriew.mock_interview.util;

import com.mockinteriew.mock_interview.dto.CandidateDTO;
import com.mockinteriew.mock_interview.model.User;

public class CandidateMapper {

    public static CandidateDTO toDTO(User user) {
        return new CandidateDTO(
                user.getName(),
                user.getEmail(),
                user.getRating(),
                user.getCreatedAt()
            );
    }

    //Remove errros and complete the method
    public static User toEntity(CandidateDTO candidateDTO) {
        User user = new User();
        user.setName(candidateDTO.getName());
        user.setEmail(candidateDTO.getEmail());
        user.setRating(candidateDTO.getRating());
        user.setCreatedAt(candidateDTO.getCreatedAt());
        return user;
    }
}
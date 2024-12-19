package com.mockinteriew.mock_interview.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Lombok annotation to generate the no-arguments constructor
@AllArgsConstructor // Lombok annotation to generate the all-arguments constructor
public class CandidateDTO {
    private String name;
    private String email;
    private Float rating;
    private LocalDateTime createdAt;
}
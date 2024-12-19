package com.mockinteriew.mock_interview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skills", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "name"}))
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "rating", nullable = false)
    private int rating;

}


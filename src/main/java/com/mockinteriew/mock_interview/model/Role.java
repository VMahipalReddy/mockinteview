package com.mockinteriew.mock_interview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Role ID (Primary Key)

    @Column(nullable = false, unique = true)
    private String name;  // Role name (candidate, interviewer, etc.)
}


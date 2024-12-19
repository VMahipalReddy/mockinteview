package com.mockinteriew.mock_interview.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reviews", uniqueConstraints = @UniqueConstraint(columnNames = {"reviewer_id", "reviewee_id"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "reviewer_id", nullable = false)
    private UUID reviewerId;

    @Column(name = "reviewee_id", nullable = false)
    private UUID revieweeId;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
}


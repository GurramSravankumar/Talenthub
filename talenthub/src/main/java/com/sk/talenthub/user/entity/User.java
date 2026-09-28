package com.sk.talenthub.user.entity;

import java.time.LocalDateTime;

import com.sk.talenthub.candidate.entity.Candidate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 254)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable = false)
    private LocalDateTime registeredAt;
    
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Candidate candidate;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        registeredAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
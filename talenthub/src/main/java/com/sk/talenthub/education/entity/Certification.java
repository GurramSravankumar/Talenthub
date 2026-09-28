package com.sk.talenthub.education.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.sk.talenthub.candidate.entity.Candidate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Certification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "candidate_id", nullable = false)
	private Candidate candidate;
	
	@Column(nullable =false ,length =200)
	private String name;
	
	@Column(nullable =false ,length =200)
	private String issuingOrganization;
	
	@Column(length =100)
	private LocalDate issueDate;
	
	
	private LocalDate expirationDate;
	
	@Column(nullable =false)
	private boolean doesNotExpire;
	
	@Column(length=100)
	private String credentialId;
	
	@Column(length = 500)
	private String credentialUrl;
	
	@Column(length = 500)
	private String certificateImageUrl;
	
	@Column(length=3000)
	private String description;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	
	@PrePersist
	protected void onCreate() {
		LocalDateTime now = LocalDateTime.now();
		createdAt = now;
		updatedAt = now;
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = LocalDateTime.now();
	}

}

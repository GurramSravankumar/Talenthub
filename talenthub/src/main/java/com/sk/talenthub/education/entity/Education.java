package com.sk.talenthub.education.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Id;

import com.sk.talenthub.candidate.entity.Candidate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "educations")
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "candidate_id", nullable = false)
	private Candidate candidate;
	
	@Column(nullable = false,length = 150)
	private String schoolName;
	
	@Column(nullable = false,length = 150)
	private String degree;
	
	@Column(length = 150)
	private String fieldOfStudy;
	
	@Column(length = 150)
	private String location;
	
	@Column(nullable = false,length = 150)
	private String startDate;
	
	private String endDate;
	
	@Column(nullable = false,length = 150)
	private boolean current;
	
	@Column(length = 3000)
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

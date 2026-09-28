package com.sk.talenthub.experience.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "candidate_id", nullable = false)
	private Candidate candidate;
	
	@Column(nullable = false,length = 150)
	private String companyName;
	
	@Column(nullable = false,length = 150)
	private String jobTitle;
	
	@Column(nullable = false,length = 150)
	private String employmentType;
	
	@Column(nullable = false,length = 150)
	private String startDate;
	
	private String endDate;
	
	@Column(nullable = false,length = 150)
	private boolean isCurrent;
	
	@Column(length = 3000)
	private String description;
	
	@Column(length = 150)
	private String location;
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	@Column(nullable = false)
	private LocalDateTime updatedAt;
	
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	

}

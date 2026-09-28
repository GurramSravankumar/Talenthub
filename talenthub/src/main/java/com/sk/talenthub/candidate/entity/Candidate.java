package com.sk.talenthub.candidate.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;

import com.sk.talenthub.education.entity.Certification;
import com.sk.talenthub.education.entity.Education;
import com.sk.talenthub.experience.entity.Experience;
import com.sk.talenthub.experience.entity.Resume;
import com.sk.talenthub.profile.entity.Profile;
import com.sk.talenthub.skill.entity.Project;
import com.sk.talenthub.skill.entity.Skill;
import com.sk.talenthub.user.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	private User user;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "profile_id", nullable = false, unique = true)
	private Profile profile;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	    name = "candidate_skills",
	    joinColumns = @JoinColumn(name = "candidate_id"),
	    inverseJoinColumns = @JoinColumn(name = "skill_id")
	)
	@Builder.Default
	private Set<Skill> skills = new HashSet<>();
	
	@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY,cascade = jakarta.persistence.CascadeType.ALL)
	private List<Education> educations = new ArrayList<>();
	
	@OneToMany(
		    mappedBy = "candidate",
		    fetch = FetchType.LAZY,
		    cascade = CascadeType.ALL,
		    orphanRemoval = true
		)
    private List<Project> projects = new ArrayList<>();
	
	@OneToMany(
		    mappedBy = "candidate",
		    fetch = FetchType.LAZY,
		    cascade = CascadeType.ALL,
		    orphanRemoval = true
		)
	private List<Certification> certifications = new ArrayList<>();
	
	@OneToMany(
		    mappedBy = "candidate",
		    fetch = FetchType.LAZY,
		    cascade = CascadeType.ALL,
		    orphanRemoval = true
		)
    private List<Resume> resumes = new ArrayList<>();
	
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

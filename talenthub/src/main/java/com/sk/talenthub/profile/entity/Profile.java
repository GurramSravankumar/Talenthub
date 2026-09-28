package com.sk.talenthub.profile.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
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
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,length = 100)
	private String firstName;
	
	@Column(nullable = false,length = 100)
	private String lastName;
	
	@Column(nullable = false,length =20)
	private String phoneNumber;
	
	@Column(nullable = false,length = 150)
	private String Headline;
	
	@Column(nullable = false,length = 2000)
    private String summary;
    
	@OneToMany(
		    mappedBy = "profile",
		    cascade = CascadeType.ALL,
		    orphanRemoval = true,
		    fetch = FetchType.LAZY
		)
	private List<Address> addresses = new ArrayList<>();
    
    @Column(nullable = false,length = 500)
    private String profilePictureUrl;
    
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

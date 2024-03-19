package com.transition.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long docId;
	
	private String userDocPath;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="userId")
	private UserProfile user;
}

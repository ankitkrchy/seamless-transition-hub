package com.transition.api.entity;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	private String userImageFilePath;
	private String fullName;
	private String email;
	private long contact;
	private String gender;
	private Date dateOfBirth;
	private String careerBreak;
	private String address;
	private boolean criminalBackground;
	
	private float tenthPercentage;
	private float twelthPercentage;
	private String universityName;
	private String organisationName;
	private String position;
	private String keySkills;
	private String description;
	private String linkedinLink;
	private String gitLink;
    @Embedded 
	private WorkExperience workexperience;
	
	@OneToMany
	private List<Employment> employments;
	
	@OneToMany
	private List<Document> documents;
	
    public UserProfile(){}
	
	
	public UserProfile(long userId, String userImageFilePath, String fullName, String email, long contact, String gender, Date dateOfBirth,
			String careerBreak, String address, boolean criminalBackground, float tenthPercentage,
			float twelthPercentage, String universityName, String organisationName, String position,
			WorkExperience workexperience, String keySkills, String description, String linkedinLink, String gitLink) {
		super();
		this.userId = userId;
		this.userImageFilePath = userImageFilePath;
		this.fullName = fullName;
		this.email = email;
		this.contact = contact;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.careerBreak = careerBreak;
		this.address = address;
		this.criminalBackground = criminalBackground;
		this.tenthPercentage = tenthPercentage;
		this.twelthPercentage = twelthPercentage;
		this.universityName = universityName;
		this.organisationName = organisationName;
		this.position = position;
		this.workexperience = workexperience;
		this.keySkills = keySkills;
		this.description = description;
		this.linkedinLink = linkedinLink;
		this.gitLink = gitLink;
	}

	
	@Override
	public String toString() {
		return "UserProfile [userId=" + userId + ", userImageFilePath=" + userImageFilePath + ", fullName=" + fullName + ", email="
				+ email + ", contact=" + contact + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", careerBreak=" + careerBreak + ", address=" + address + ", criminalBackground=" + criminalBackground
				+ ", tenthPercentage=" + tenthPercentage + ", twelthPercentage=" + twelthPercentage
				+ ", universityName=" + universityName + ", organisationName=" + organisationName + ", position="
				+ position + ", workexperience=" + workexperience + ", keySkills=" + keySkills + ", description="
				+ description + ", linkedinLink=" + linkedinLink + ", gitLink=" + gitLink + "]";
	}


		
}
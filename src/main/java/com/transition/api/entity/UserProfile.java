package com.transition.api.entity;
import java.sql.Date;

import org.hibernate.annotations.GenerationTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	private String photoUrl;
	private String fullName;
	private String email;
	private long contact;
	private String gender;
	private Date dateOfBirth;
	private String carrerBreak;
	private String adress;
	private boolean criminalBackground;
	private float tenthPercentage;
	private float twelthPercentage;
	private String universityName;
	private String organisationName;
	private String position;
	private WorkExperience workexperience;	
	private String keySkills;
	private String description;
	private String linkedinLink;
	private String gitLink;
	
	
	
	
	
	public UserProfile(long userId, String photoUrl, String fullName, String email, long contact, String gender, Date dateOfBirth,
			String carrerBreak, String adress, boolean criminalBackground, float tenthPercentage,
			float twelthPercentage, String universityName, String organisationName, String position,
			WorkExperience workexperience, String keySkills, String description, String linkedinLink, String gitLink) {
		super();
		this.userId = userId;
		this.photoUrl = photoUrl;
		this.fullName = fullName;
		this.email = email;
		this.contact = contact;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.carrerBreak = carrerBreak;
		this.adress = adress;
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

	
	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getPhotoUrl() {
		return photoUrl;
	}
	
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getContact() {
		return contact;
	}
	
	public void setContact(long contact) {
		this.contact = contact;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getCarrerBreak() {
		return carrerBreak;
	}
	
	public void setCarrerBreak(String carrerBreak) {
		this.carrerBreak = carrerBreak;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public boolean isCriminalBackground() {
		return criminalBackground;
	}
	
	public void setCriminalBackground(boolean criminalBackground) {
		this.criminalBackground = criminalBackground;
	}
	
	public float getTenthPercentage() {
		return tenthPercentage;
	}
	
	public void setTenthPercentage(float tenthPercentage) {
		this.tenthPercentage = tenthPercentage;
	}
	
	public float getTwelthPercentage() {
		return twelthPercentage;
	}
	
	public void setTwelthPercentage(float twelthPercentage) {
		this.twelthPercentage = twelthPercentage;
	}
	
	public String getUniversityName() {
		return universityName;
	}
	
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	
	public String getOrganisationName() {
		return organisationName;
	}
	
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public WorkExperience getWorkexperience() {
		return workexperience;
	}
	
	public void setWorkexperience(WorkExperience workexperience) {
		this.workexperience = workexperience;
	}
	
	public String getKeySkills() {
		return keySkills;
	}
	
	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLinkedinLink() {
		return linkedinLink;
	}
	
	public void setLinkedinLink(String linkedinLink) {
		this.linkedinLink = linkedinLink;
	}
	
	public String getGitLink() {
		return gitLink;
	}
	
	public void setGitLink(String gitLink) {
		this.gitLink = gitLink;
	}


	@Override
	public String toString() {
		return "UserProfile [userId=" + userId + ", photoUrl=" + photoUrl + ", fullName=" + fullName + ", email="
				+ email + ", contact=" + contact + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", carrerBreak=" + carrerBreak + ", adress=" + adress + ", criminalBackground=" + criminalBackground
				+ ", tenthPercentage=" + tenthPercentage + ", twelthPercentage=" + twelthPercentage
				+ ", universityName=" + universityName + ", organisationName=" + organisationName + ", position="
				+ position + ", workexperience=" + workexperience + ", keySkills=" + keySkills + ", description="
				+ description + ", linkedinLink=" + linkedinLink + ", gitLink=" + gitLink + "]";
	}
		
}
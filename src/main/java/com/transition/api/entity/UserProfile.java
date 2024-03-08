package com.transition.api.entity;

import java.sql.Date;

final class UserProfile {

	String photoUrl;
	String fullName;
	String email;
	long contact;
	String gender;
	Date dateOfBirth;
	String carrerBreak;
	String adress;
	boolean criminalBackground;
	float tenthPercentage;
	float twelthPercentage;
	String universityName;
	String organisationName;
	String position;
  //wordexperience	
	String keySkills;
	String description;
	String linkedinLink;
	String gitLink;
	
	
	public UserProfile(String photoUrl, String fullName, String email, long contact, String gender, Date dateOfBirth,
			String carrerBreak, String adress, boolean criminalBackground, float tenthPercentage,
			float twelthPercentage, String universityName, String organisationName, String position, String keySkills,
			String description, String linkedinLink, String gitLink) {
		super();
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
		this.keySkills = keySkills;
		this.description = description;
		this.linkedinLink = linkedinLink;
		this.gitLink = gitLink;
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
		return "UserProfile [photoUrl=" + photoUrl + ", fullName=" + fullName + ", email=" + email + ", contact="
				+ contact + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", carrerBreak=" + carrerBreak
				+ ", adress=" + adress + ", criminalBackground=" + criminalBackground + ", tenthPercentage="
				+ tenthPercentage + ", twelthPercentage=" + twelthPercentage + ", universityName=" + universityName
				+ ", organisationName=" + organisationName + ", position=" + position + ", keySkills=" + keySkills
				+ ", description=" + description + ", linkedinLink=" + linkedinLink + ", gitLink=" + gitLink
				+ ", getPhotoUrl()=" + getPhotoUrl() + ", getFullName()=" + getFullName() + ", getEmail()=" + getEmail()
				+ ", getContact()=" + getContact() + ", getGender()=" + getGender() + ", getDateOfBirth()="
				+ getDateOfBirth() + ", getCarrerBreak()=" + getCarrerBreak() + ", getAdress()=" + getAdress()
				+ ", isCriminalBackground()=" + isCriminalBackground() + ", getTenthPercentage()="
				+ getTenthPercentage() + ", getTwelthPercentage()=" + getTwelthPercentage() + ", getUniversityName()="
				+ getUniversityName() + ", getOrganisationName()=" + getOrganisationName() + ", getPosition()="
				+ getPosition() + ", getKeySkills()=" + getKeySkills() + ", getDescription()=" + getDescription()
				+ ", getLinkedinLink()=" + getLinkedinLink() + ", getGitLink()=" + getGitLink() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}

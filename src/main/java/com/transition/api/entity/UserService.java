package com.transition.api.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity
public class UserService {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long serviceId;

	@ManyToOne
//	@JsonIgnore
	@JoinColumn(name="userId")
	private UserProfile user;
	
	private String currentCompanyName;
	private String currentRole;
	
	private Date startDate;
	private Date endDate;
	private boolean currentlyWorking;
	private String employmentType;
	private String project;
	private String responsibilities;
	private String technologyUsed;
	private String achievements;
	private String certifications;
	private String location;
	
	
	UserService(){};
	public UserService(long serviceId, UserProfile user, String currentCompanyName, String currentRole, Date startDate,
			Date endDate, boolean currentlyWorking, String employmentType, String project, String responsibilities,
			String technologyUsed, String achievements, String certifications, String location) {
		super();
		this.serviceId = serviceId;
		this.user = user;
		this.currentCompanyName = currentCompanyName;
		this.currentRole = currentRole;
		this.startDate = startDate;
		this.endDate = endDate;
		this.currentlyWorking = currentlyWorking;
		this.employmentType = employmentType;
		this.project = project;
		this.responsibilities = responsibilities;
		this.technologyUsed = technologyUsed;
		this.achievements = achievements;
		this.certifications = certifications;
		this.location = location;
	}
	
	public long getServiceId() {
		return serviceId;
	}
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	public UserProfile getUser() {
		return user;
	}
	public void setUser(UserProfile user) {
		this.user = user;
	}
	public String getCurrentCompanyName() {
		return currentCompanyName;
	}
	public void setCurrentCompanyName(String currentCompanyName) {
		this.currentCompanyName = currentCompanyName;
	}
	public String getCurrentRole() {
		return currentRole;
	}
	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isCurrentlyWorking() {
		return currentlyWorking;
	}
	public void setCurrentlyWorking(boolean currentlyWorking) {
		this.currentlyWorking = currentlyWorking;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}
	public String getTechnologyUsed() {
		return technologyUsed;
	}
	public void setTechnologyUsed(String technologyUsed) {
		this.technologyUsed = technologyUsed;
	}
	public String getAchievements() {
		return achievements;
	}
	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}
	public String getCertifications() {
		return certifications;
	}
	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "UserService [serviceId=" + serviceId + ", user=" + user + ", currentCompanyName=" + currentCompanyName
				+ ", currentRole=" + currentRole + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", currentlyWorking=" + currentlyWorking + ", employmentType=" + employmentType + ", project="
				+ project + ", responsibilities=" + responsibilities + ", technologyUsed=" + technologyUsed
				+ ", achievements=" + achievements + ", certifications=" + certifications + ", location=" + location
				+ "]";
	}
}
	
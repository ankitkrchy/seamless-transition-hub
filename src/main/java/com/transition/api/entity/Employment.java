package com.transition.api.entity;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class Employment {

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
	
	
	Employment(){};
	public Employment(long serviceId, UserProfile user, String currentCompanyName, String currentRole, Date startDate,
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
	
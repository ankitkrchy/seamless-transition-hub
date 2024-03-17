package com.transition.api.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class WorkExperience {

	private int years;
	private int months;
	
	public WorkExperience() {}
	  
	public WorkExperience(int years, int months ) {
		this.years = years;
		this.months = months;
	}

	
	@Override
	public String toString() {
		return years+" years "+ months + " months ";
	}
	
	
}
package com.transition.api.entity;

public class WorkExperience {

	private int years;
	private int months;
	
	public WorkExperience(int years, int months ) {
		this.years = years;
		this.months = months;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	
	@Override
	public String toString() {
		return years+" years "+ months + " months ";
	}
	
	
}
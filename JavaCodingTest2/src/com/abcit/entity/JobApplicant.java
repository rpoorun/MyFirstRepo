package com.abcit.entity;

public class JobApplicant {
	
	private int applicantId;
	private String applicantName; 
	private int gd; //group discussion feedback
	private int technicalInterview;
	private int hrInterview;
	
	
	public JobApplicant(int applicantId, String applicantName) {
		this.applicantId = applicantId;
		this.applicantName = applicantName;
	}


	public int getGd() {
		return gd;
	}


	public void setGd(int gd) {
		this.gd = gd;
	}


	public int getTechnicalInterview() {
		return technicalInterview;
	}


	public void setTechnicalInterview(int technicalInterview) {
		this.technicalInterview = technicalInterview;
	}


	public int getHRinterview() {
		return hrInterview;
	}


	public void setHRinterview(int hrInterview) {
		this.hrInterview = hrInterview;
	}


	public int getApplicantId() {
		return applicantId;
	}


	public String getApplicantName() {
		return applicantName;
	}


	@Override
	public String toString() {
		return "JobApplicant [applicantId=" + applicantId + ", applicantName=" + applicantName + ", gd=" + gd
				+ ", technicalInterview=" + technicalInterview + ", HRinterview=" + hrInterview + "]";
	}
	
	
	
	

}

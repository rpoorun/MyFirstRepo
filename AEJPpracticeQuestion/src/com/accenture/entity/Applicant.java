package com.accenture.entity;

public class Applicant {
	
	private int applicantId;
	private String applicantName; 
	private int groupDiscussion; 
	private int technicalReview;
	private int HRinterview;
	
	public Applicant(int applicantId, String applicantName) {
		super();
		this.applicantId = applicantId;
		this.applicantName = applicantName;
	}

	public int getGroupDiscussion() {
		return groupDiscussion;
	}

	public void setGroupDiscussion(int groupDiscussion) {
		this.groupDiscussion = groupDiscussion;
	}

	public int getTechnicalReview() {
		return technicalReview;
	}

	public void setTechnicalReview(int technicalReview) {
		this.technicalReview = technicalReview;
	}

	public int getHRinterview() {
		return HRinterview;
	}

	public void setHRinterview(int hRinterview) {
		HRinterview = hRinterview;
	}

	public int getApplicantId() {
		return applicantId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", applicantName=" + applicantName + ", groupDiscussion="
				+ groupDiscussion + ", technicalReview=" + technicalReview + ", HRinterview=" + HRinterview + "]";
	}
	
	
	
	

}

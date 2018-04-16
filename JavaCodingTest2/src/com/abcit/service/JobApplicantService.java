package com.abcit.service;

import com.abcit.entity.JobApplicant;
import com.abcit.exception.InvalidFeedbackException;

public interface JobApplicantService {
	
	//method to assign the feedback to the object apl
	void assignFeedback(JobApplicant apl, int gd, int technicalInterview, int hrInterview) throws InvalidFeedbackException;
	
	
	//method to check if object apl has passed all interviews
	boolean applicantSelected(JobApplicant apl);

}

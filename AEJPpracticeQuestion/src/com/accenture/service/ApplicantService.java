package com.accenture.service;

import com.accenture.entity.Applicant;
import com.accenture.exceptions.InvalidFeedbackException;

public interface ApplicantService {
	
	//abstract method() to assign the values of group Discussion, technical interview and HR interview to the object applicant
	void assignFeedback(Applicant apl, int group, int tech, int hr) throws InvalidFeedbackException;
	
	//abstract method() to return whether the applicant is selected or not
	boolean applicantSelected(Applicant apl);

}

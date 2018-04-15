package com.accenture.service;

import com.accenture.entity.Applicant;
import com.accenture.exceptions.InvalidFeedbackException;

//this class implements the interface ApplicantService
public class ApplicantServiceImpl implements ApplicantService {

	@Override
	public void assignFeedback(Applicant apl, int group, int tech, int hr) throws InvalidFeedbackException {
		if (group < 0 || group > 10) {
			//for invalid feedback mark for the group interview, JVM will stop
			throw new InvalidFeedbackException("Feedback should between 0 to 10 only");
		}
		
		//for valid feedback mark for the group interview, mark group is assigned to the applicant
		apl.setGroupDiscussion(group);
		
		if (tech < 0 || tech > 10) {
			//for invalid feedback mark for the technical interview, JVM will stop
			throw new InvalidFeedbackException("Feedback should between 0 to 10 only");
		}
		
		//for valid feedback mark for the technical interview, mark group is assigned to the applicant
		apl.setTechnicalReview(tech);
		
		if (hr < 0 || hr > 10) {
			//for invalid feedback mark for the HR interview, JVM will stop
			throw new InvalidFeedbackException("Feedback should between 0 to 10 only");
		}
		
		//for valid feedback mark for the HR interview, mark group is assigned to the applicant
		apl.setHRinterview(hr);

	}
	

	@Override
	public boolean applicantSelected(Applicant apl) {
		//initialize a counter to record number of module passed
		int counter = 0; 
		
		if(apl.getGroupDiscussion() >= 5) {
			//passed the group discussion interview
			counter ++;
		}
		
		if(apl.getHRinterview() >= 5) {
			//passed the HR interview 
			counter++;
		}
		
		if(apl.getTechnicalReview() >= 7) {
			//passed the Technical interview
			counter++;
		}
		
		//if counter is equal 3, means the applicant passed in all three interviews
		if(counter == 3) { 
			return true;
		}
		else {
			return false;
		}
	
	}

}

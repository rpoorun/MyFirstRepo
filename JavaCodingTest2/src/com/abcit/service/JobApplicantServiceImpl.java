package com.abcit.service;

import com.abcit.entity.JobApplicant;
import com.abcit.exception.InvalidFeedbackException;

public class JobApplicantServiceImpl implements JobApplicantService {

	@Override
	public void assignFeedback(JobApplicant apl, int gd, int technicalInterview, int hrInterview)
			throws InvalidFeedbackException {

		// validate if feedback for group discussion is between 0 to 10
		if (gd < 0 || gd > 10) {
			// if feedback mark is not valid, throws an exception
			throw new InvalidFeedbackException("Error! Feedback for group discussion should be betwen 0 to 10");
		}
		// if feedback is valid, assign to object apl
		apl.setGd(gd);

		// validate if feedback for technical interview is between 0 to 10
		if (technicalInterview < 0 || technicalInterview > 10) {
			// if feedback is not valid, throws an exception
			throw new InvalidFeedbackException("Error! Feedback for technical interview should be between 0 to 10");
		}
		// if feedback is valid, assign to object apl
		apl.setTechnicalInterview(technicalInterview);

		// validate if feedback for HR interview if between 0 to 10
		if (hrInterview < 0 || hrInterview > 10) {
			// if feedback if not valid, throws an exception
			throw new InvalidFeedbackException("Error! Feedback for HR interview should be between 0 to 10");
		}
		// if feedback is valid, assign to object apl
		apl.setHRinterview(hrInterview);

	}

	@Override
	public boolean applicantSelected(JobApplicant apl) {
		// assign counter to record the number of interview passed
		int counter = 0;

		// validate the feedback for group discussion
		if (apl.getGd() >= 7) {
			// if passed the group discussion, increment counter
			counter++;
		}

		// validate the feedback for technical interview
		if (apl.getTechnicalInterview() >= 8) {
			// if passed the technical interview, increment counter
			counter++;
		}

		// validate the feedback for HR interview
		if (apl.getHRinterview() >= 7) {
			// if passed the HR interview, increment counter
			counter++;
		}

		// evaluate the counter
		if (counter == 3) {
			// if passed all 3 interview return true for passed
			return true;
		} else {
			// if not passed in all 3 interview return false for failed
			return false;
		}
	}

}

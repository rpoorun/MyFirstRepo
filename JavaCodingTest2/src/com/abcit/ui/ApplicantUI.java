package com.abcit.ui;

import java.util.Scanner;

import com.abcit.entity.JobApplicant;
import com.abcit.exception.InvalidFeedbackException;
import com.abcit.service.JobApplicantService;
import com.abcit.service.JobApplicantServiceImpl;

public class ApplicantUI {
	public static void main(String[] args) {
		//create object Scanner to read the keyboard input
		Scanner input = new Scanner(System.in);
		
		//create object service to use the functionalities of service layer
		JobApplicantService service = new JobApplicantServiceImpl();
		
		System.out.println("Create a new applicant record");
		
		//do check the applicant id
		boolean correctId;
		int applicantId;
		do {
			System.out.print("Applicant ID -> ");
			applicantId = input.nextInt();
			
			//check if ID is positive
			if(applicantId > 0) {
				//assign true to exit the loop
				correctId = true;
			}
			else {
				//assign false to re-read the id
				System.out.println("Error! Applicant ID cannot be negative!");
				correctId = false;
			}
		}while(!correctId);
		
		System.out.print("Applicant Name -> ");
		String applicantName = input.next()	;
		
		//create the object apl from JobApplicant
		JobApplicant apl = new JobApplicant(applicantId, applicantName);
		
		//re-ask for the feedback mark for interview if exception is thrown
		boolean noExcpt = true; 
		do {
			//read value for the feedback of individual interview 
			System.out.print("Insert feedback for Group Discussion: ");
			int gd = input.nextInt();
			System.out.print("Insert feedback for Technical Interview: ");
			int technicalInterview = input.nextInt();
			System.out.print("Insert feedback for HR Interview: ");
			int hrInterview = input.nextInt();
			
			//assign the feedback to object apl using the service object
			try {
				service.assignFeedback(apl, gd, technicalInterview, hrInterview);
				
				//check if applicant has been selected
				boolean result = 	service.applicantSelected(apl);
				
				//if result if true, applicant passed
				if(result) {
					System.out.println(apl.getApplicantName()+" has passed all interview");
				}
				else {
					//if result if false, applicant failed
					System.out.println(apl.getApplicantName()+" has failed the interview");
				}
				
			} catch (InvalidFeedbackException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				//print the error message from the exception occurred
				System.out.println(e.getMessage());
				noExcpt = false;
			}
			
		}while(!noExcpt);
			
			
		input.close();
		
	}// main()

}// class

package com.accenture.ui;

import java.util.Scanner;

import com.accenture.entity.Applicant;
import com.accenture.exceptions.InvalidFeedbackException;
import com.accenture.service.ApplicantService;
import com.accenture.service.ApplicantServiceImpl;

public class ApplicantUI {
	
	public static void main(String[] args) {
		//Scanner object to read all value from the keyboard
		Scanner input = new Scanner(System.in);
		
		//create the object service to use the service functionalities
		ApplicantService service = new ApplicantServiceImpl();
		
		System.out.println("Record for new Applicant");
		System.out.print("Enter Application ID: ");
		//record the applicantId
		int applicantId = input.nextInt();
		System.out.print("Enter Applicant Name: ");
		String applicantName = input.next();
		
		//create object applicant to store the values
		Applicant apl = new Applicant(applicantId, applicantName);
		
		//read the values for the interview
		System.out.println("Enter value for Group Discussion:	");
		int group = input.nextInt();
		System.out.println("Enter value for Technical Interview:");
		int tech = input.nextInt();
		System.out.println("Enter value for HR Interview: ");
		int hr = input.nextInt();
		
		//parsing the values to the assigned methods in service
		try {
			service.assignFeedback(apl, group, tech, hr);
			
			//check if the applicant has passed or not
			boolean result = service.applicantSelected(apl);
			
			if(result) {
				//if result return true, applicant has passed
				System.out.println(apl.getApplicantName()+" has passed the interviews!");
			}
			else {
				//if result return false, applicant has failed
				System.out.println(apl.getApplicantName()+" has failed the interviews!");
			}
			
		} catch (InvalidFeedbackException e) {
			//read and print the message from the exception
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	
		
		
		//close the scanner function after use
		input.close(); 
	}//main()

}//class

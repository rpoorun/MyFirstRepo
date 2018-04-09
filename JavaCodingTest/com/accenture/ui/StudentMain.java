package com.accenture.ui;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.accenture.beans.Student;
import com.accenture.exceptions.InvalidMarksException;
import com.accenture.service.StudentService;
import com.accenture.service.StudentServiceImpl;

public class StudentMain {
	
	public static void main(String[] args) {
		
		final int ROLL_COUNT = 2;
		
		StudentService service = new StudentServiceImpl();
		
		Scanner input = new Scanner(System.in);
		
		List<Student> stdArray = new ArrayList<>();
		
		for (int i = 0 ; i< ROLL_COUNT;) {
			System.out.println("Create a new Student Record:");
			System.out.print("Roll No -> ");
			int rollNo = input.nextInt();
			System.out.print("Student Name -> ");
			String studentName = input.next();
			Student std = new Student(rollNo, studentName);
			stdArray.add(i, std);
			i++;
		}	
		
		
		
		System.out.println("----------------------------------");
		
		for(int j = 0; j <ROLL_COUNT;j++) {
			boolean done = false;
			do {
				Student std = stdArray.get(j);
			
				int rollNo = std.getRollNo();
				String studentName = std.getStudentName();
				
				System.out.println("Enter Marks for "+rollNo+" "+studentName);
				System.out.print("Physics -> ");
				int phy = input.nextInt();
				
				System.out.print("Chemistry -> ");
				int chem = input.nextInt();
				
				System.out.print("Java Programming -> ");
				int java = input.nextInt();
				
				try {
					service.assignMarks(std, phy, chem, java);
					
					boolean result = service.checkResult(std);
					
					if (result) {
						System.out.println("The Student "+studentName+ " has passed in all modules");
					}
					else {
						System.out.println("The Student "+studentName+" has failed!");
					}
					System.out.println("--------------------------");
					
					done = true;
					
				} catch (InvalidMarksException e) {
					System.out.println(e.getMessage());
					System.out.println("Please Enter Marks again:");
					done = false;
					
				}
			}while(!done);
	
				
			
			}
		
		
		input.close();
	} // main
} //class


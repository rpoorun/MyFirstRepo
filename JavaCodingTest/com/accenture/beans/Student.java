package com.accenture.beans;
import com.accenture.exceptions.*;

public class Student {
	private int rollNo;
	private String studentName;
	private int physics;
	private int chemistry;
	private int javaProgramming;
	
	
	
	public Student(int rollNo, String studentName) {
		this.rollNo =rollNo;
		this.studentName = studentName;
	}
	
	
	public Student(int rollNo, String studentName, int physics, int chemistry, int javaProgramming) throws InvalidMarksException {
		this.rollNo = rollNo;
		this.studentName = studentName;
		setPhysics(physics);
		setChemistry(chemistry);
		setJavaProgramming(javaProgramming);
		
	}

	public int getRollNo() {
		return rollNo;
	}

	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) throws InvalidMarksException{
			if(physics < 0 || physics > 100) {
				throw new InvalidMarksException("Physics marks cannot be negative or greater that 100!");
				
			}
			else {
				this.physics = physics;
			}
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) throws InvalidMarksException {
		if (chemistry < 0 || chemistry > 100) {
			throw new InvalidMarksException("Chemistry marks cannot be negative or greater that 100!");
		}
		else {
			this.chemistry = chemistry;
		}
	}

	public int getJavaProgramming() {
		return javaProgramming;
	}

	public void setJavaProgramming(int javaProgramming) throws InvalidMarksException{
		if (javaProgramming < 0 || javaProgramming > 100) {
			throw new InvalidMarksException("Java Programming marks cannot be negative or greater that 100!");
		}
		else {
			this.javaProgramming = javaProgramming;
		}
	}
	
	
	
	
	
	
	
}

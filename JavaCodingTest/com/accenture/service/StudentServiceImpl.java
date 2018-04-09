package com.accenture.service;

import com.accenture.beans.Student;
import com.accenture.exceptions.InvalidMarksException;

public class StudentServiceImpl implements StudentService {

	@Override
	public void assignMarks(Student student, int physics, int chemistry, int javaProgramming) throws InvalidMarksException {
			student.setPhysics(physics);
			student.setChemistry(chemistry);
			student.setJavaProgramming(javaProgramming);
		
		
	}

	@Override
	public boolean checkResult(Student student) {
		int phy, chem, java;
		int counter = 0;
		
		phy = student.getPhysics();
		chem = student.getChemistry();
		java = student.getJavaProgramming();
				
		if (phy > 34) {
			counter ++;
		}
		if (chem > 34) {
			counter ++;
		}
		if (java > 34) {
			counter ++;
		}
		
		
		if (counter == 3) {
			return true;
		}
		else {
			return false;
		}
	}

}

package com.accenture.service;

import com.accenture.beans.Student;
import com.accenture.exceptions.InvalidMarksException;

public interface StudentService {

	void assignMarks(Student student, int physics, int chemistry, int javaProgramming) throws InvalidMarksException;
	
	boolean checkResult(Student student);
}

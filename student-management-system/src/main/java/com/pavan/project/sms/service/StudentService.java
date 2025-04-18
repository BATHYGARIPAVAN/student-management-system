package com.pavan.project.sms.service;

import java.util.List;

import com.pavan.project.sms.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentId(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
}

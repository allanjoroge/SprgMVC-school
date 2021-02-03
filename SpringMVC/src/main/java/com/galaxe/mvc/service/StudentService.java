package com.galaxe.mvc.service;

import java.util.List;

import com.galaxe.mvc.model.Student;

public interface StudentService {

	void createStudentser(Student student);
	List<Student> getAllStudents();
	Student getStudentbyId(Long id);
	void deleteStudentSer(Long id);
	Student findSer(Long id);
	void updateStudentSer(Student student);
	Student loginSer(String username, String password);
}

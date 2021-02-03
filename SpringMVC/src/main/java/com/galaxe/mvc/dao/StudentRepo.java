package com.galaxe.mvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.galaxe.mvc.model.Student;

@Transactional
public interface StudentRepo {

	void createStudent(Student student);
	List<Student> findAll();
	Student findById(Long id);
	void deleteStudent(Long id);
	Student find(Long id);
	void updateStudent(Student student);
	Student login(String username, String password);

}

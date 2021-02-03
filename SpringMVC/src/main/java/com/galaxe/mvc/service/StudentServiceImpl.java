package com.galaxe.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxe.mvc.dao.StudentRepo;
import com.galaxe.mvc.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo stRepo;
	SessionFactory sessFact;

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = stRepo.findAll();
		return list;
	}

	@Override
	public Student getStudentbyId(Long id) {
		return stRepo.findById(id);
	}

	@Override
	public void deleteStudentSer(Long id) {
		stRepo.deleteStudent(id);
	}

	@Override
	public Student findSer(Long id) {
		return stRepo.find(id);
	}

	@Override
	public void createStudentser(Student student) {
		stRepo.createStudent(student);
	}

	@Override
	public void updateStudentSer(Student student) {
		stRepo.updateStudent(student);
	}

	@Override
	public Student loginSer(String username, String password) {
		return stRepo.login(username, password);
	}
}

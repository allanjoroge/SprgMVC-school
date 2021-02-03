package com.galaxe.mvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.galaxe.mvc.model.Student;

@Repository
public class StudentRepoImpl implements StudentRepo {

	@Autowired
	SessionFactory sessFact;

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() {

		Session session = sessFact.openSession();
		Query query = session.createQuery("from Student");
		List<Student> list = query.list();
		session.close();
		return list;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public Student findById(Long id) {
		Session session = sessFact.openSession();
		Query query = session.createQuery("from Student where id = "+ id);
		Student student = null;
		List<Student> list = query.list();
		if (list != null && list.size() > 0) {
			student = list.get(0);
		}
		session.close();
		return student;
	}

	@Override
	public void deleteStudent(Long id) {
		Session session = sessFact.openSession();
		Student student = findById(id);
		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Student find(Long id) {
		Session session = sessFact.openSession();
		return (Student) session.get(Student.class, id);
	}

	@Override
	public void createStudent(Student student) {
		Session session = sessFact.openSession();
		session.save(student);
		session.close();
	}

	@Override
	public void updateStudent(Student student) {
		Session session = sessFact.openSession();
		session.beginTransaction();
		session.saveOrUpdate(student);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Student login(String username, String password) {

		List<Student> stu = findAll();
		try {

			for (int i = 0; i < stu.size(); i++) {
				if (stu.get(i).getUsername().equalsIgnoreCase(username)
						&& stu.get(i).getPassword().equalsIgnoreCase(password)) {
					return stu.get(i);
				}
			}

		} catch (NullPointerException e) {
		}
		return null;
	}
}

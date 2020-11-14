package com.fl.school.dao;
 
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fl.school.modal.Student;
import com.fl.school.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

	private static StudentDaoImpl studentDaoImpl = null;

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Long saveStudent(Student student) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long) session.save(student);
		transaction.commit();
		session.close();

		return id;
	}

	public void updateStudent(Student student) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(student);
		transaction.commit();
		session.close();
	}

	public void deleteStudent(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		transaction.commit();
		session.close();
	}

	public Student findStudentById(Long id) {
		Session session = this.sessionFactory.openSession();
		Student student = session.get(Student.class, id);
		session.close();

		return student;
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAllStudents() {
		Session session = this.sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class).list();
		session.close();

		return studentList;
	}

	public static StudentDao getInstance() {
		if (studentDaoImpl == null)
			studentDaoImpl = new StudentDaoImpl();

		return studentDaoImpl;
	}
}


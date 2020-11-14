package com.fl.school.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fl.school.modal.Subject;
import com.fl.school.modal.Teacher;
import com.fl.school.util.HibernateUtil;

public class TeacherDaoImpl implements TeacherDao {

	private static TeacherDaoImpl teacherDaoImpl = null;

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void saveTeacher(Teacher teacher) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		  session.save(teacher);
		transaction.commit();
		session.close();

		 
	}

	public void updateTeacher(Teacher teacher) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(teacher);
		transaction.commit();
		System.out.println("updateteacher from Doa=");

		session.close();
	}

	public void deleteTeacher(Long id) {
		System.out.println("printing Id from delete call in TeacherDoa methid "+ id);
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Teacher teacher = session.get(Teacher.class, id);
		session.delete(teacher);
		transaction.commit();
		session.close();
	}

	public Teacher findTeacherById(Long id) {
		Session session = this.sessionFactory.openSession();
		Teacher teacher = session.get(Teacher.class, id);
		session.close();

		return teacher;
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> findAllTeachers() {
		Transaction transaction = null;
		List<Teacher> listOfTeacher = null;
		try (Session session = this.sessionFactory.openSession();) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			System.out.println("====inside reacher===");
			listOfTeacher = session.createQuery("from Teacher").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfTeacher;
	}

 
	public static TeacherDao getInstance() {
		if (teacherDaoImpl == null)
			teacherDaoImpl = new TeacherDaoImpl();

		return teacherDaoImpl;
	}

	@Override
	public Set<Subject> findSubjectByTeacher(long teacherId) {
		Session session = this.sessionFactory.openSession();
		Teacher teacher = session.get(Teacher.class, teacherId);
		Set<Subject> subjects = teacher.getSubjects();
		session.close();
		return subjects;
	}
	
	@Override
	public void addTeacherSubject(Teacher teacher,Set<Subject> subjects) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Teacher teacherObj = session.get(Teacher.class, teacher.getTeacherId());
		teacherObj.setSubjects(subjects);
		session.update(teacherObj);
		transaction.commit();
		System.out.println("updateteachersubject from Doa=");

		session.close();
	}
	
	@Override
	public void updateTeacherSubject(Teacher teacher,Set<Subject> subjects) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Teacher teacherObj = session.get(Teacher.class, teacher.getTeacherId());
		teacherObj.setSubjects(subjects);
		session.update(teacherObj);
		transaction.commit();
		System.out.println("updateteachersubject from Doa=");

		session.close();
	}
	
	@Override
	public void deleteTeacherSubject(Teacher teacher) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Teacher teacherObj = session.get(Teacher.class, teacher.getTeacherId());
		teacherObj.setSubjects(null);
		session.update(teacherObj);
		transaction.commit();
		System.out.println("updateteachersubject from Doa=");

		session.close();
	}
}


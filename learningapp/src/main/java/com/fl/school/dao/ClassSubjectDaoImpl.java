package com.fl.school.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.fl.school.modal.ClassSubject;
import com.fl.school.modal.Classroom;
import com.fl.school.modal.Student;
import com.fl.school.modal.Subject;
import com.fl.school.modal.Teacher;
import com.fl.school.util.HibernateUtil;

public class ClassSubjectDaoImpl implements ClassSubjectDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private static ClassSubjectDaoImpl classSubjectDaoImpl = null;
	
	@Override
	public void saveClassSubject(ClassSubject classsubject) {
	
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(classsubject);
		transaction.commit();
		session.close();		 
		
	}

	@Override
	public void updateClassSubject(ClassSubject classsubject) {
		
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(classsubject);
		transaction.commit();
		session.close();
		
	}

	@Override
	public void deleteClassSubject(Long id) {
		
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		ClassSubject classSubject = session.get(ClassSubject.class, id);
		session.remove(classSubject);
		transaction.commit();
		session.close();		
	}

	@Override
	public ClassSubject findClassSubjectById(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		ClassSubject classSubject = session.get(ClassSubject.class, id);
		transaction.commit();
		session.close();
		return classSubject;
	}

	@Override
	public List<ClassSubject> findAllClassSubjects() {
		Session session = this.sessionFactory.openSession();		
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ClassSubject> query = builder.createQuery(ClassSubject.class);
        Root<ClassSubject> root = query.from(ClassSubject.class);
        query.select(root);
        Query<ClassSubject> q=session.createQuery(query);
        List<ClassSubject> classsubjectList=q.getResultList();	        
		session.close();
		return classsubjectList;
	}
	
	
	
	
	public static ClassSubjectDao getInstance() {
		if (classSubjectDaoImpl == null)
			classSubjectDaoImpl = new ClassSubjectDaoImpl();

		return classSubjectDaoImpl;
	}

	@Override
	public List<Subject> findAllSubjectsByCalssId(Long classId) {
		
		Session session = this.sessionFactory.openSession();		
		TypedQuery<Long> query = session.createQuery("select a.subjectId from ClassSubject a where a.classId = :cId",Long.class);
		query.setParameter("cId", classId);
		List<Long> subjectIds = query.getResultList();
		System.out.println(subjectIds);
		List<Subject> subjectList = subjectIds.stream().map(e->session.get(Subject.class, e)).collect(Collectors.toList());
		session.close();
		return subjectList;
	}

	@Override
	public List<Teacher> findAllTeachersByCalssId(Long classId) {

		Session session = this.sessionFactory.openSession();		
		TypedQuery<Long> query = session.createQuery("select a.teacherId from ClassSubject a where a.classId = :cId",Long.class);
		query.setParameter("cId", classId);
		List<Long> teacherIds = query.getResultList();
		System.out.println(teacherIds);
		List<Teacher> teacherList = teacherIds.stream().map(e->session.get(Teacher.class, e)).collect(Collectors.toList());
		session.close();
		return teacherList;
	}
	
	@Override
	public List<Student> findAllStudentsByCalssId(Long classId) {

		Session session = this.sessionFactory.openSession();	
		//TypedQuery<Student> query = session.createQuery("from Student a where a.classId = :cId",Student.class);
		//query.setParameter("cId", classId);
		//List<Student> studentlist = query.getResultList();
		Classroom classroom = session.get(Classroom.class, classId);
		List<Student> studentlist = classroom.getStudents();
		session.close();
		return studentlist;
	}

	
}

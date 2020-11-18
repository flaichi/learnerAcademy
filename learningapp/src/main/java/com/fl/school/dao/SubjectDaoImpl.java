package com.fl.school.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
 
import org.hibernate.Transaction;
//import org.hibernate.query.Query;

import com.fl.school.modal.Subject;
import com.fl.school.util.HibernateUtil;

public class SubjectDaoImpl implements SubjectDao {
	
	//private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private static SubjectDaoImpl subjectDaoImpl = null;


	 
	public void saveSubject(Subject subject) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(subject);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
 	 
	}

	 
	public void updateSubject(Subject subject) {
		 Session session = HibernateUtil.getSessionFactory().openSession() ;
		Transaction transaction = session.beginTransaction();
		session.update(subject);
		transaction.commit();
		System.out.println("now updating subject record");

		session.close();

	}

	 
	public void deleteSubject(Long id) {
		 Session session = HibernateUtil.getSessionFactory().openSession() ;
		Transaction transaction = session.beginTransaction();
		Subject subject = session.get(Subject.class, id);
		session.delete(subject);
		transaction.commit();
		System.out.println("now deleting subject record");

		session.close();
	}

	 
	public Subject findSubjectById(Long id) {
		 Session session = HibernateUtil.getSessionFactory().openSession() ;
	Subject subject = session.get(Subject.class, id);
		session.close();

		return subject;
	}
	
	public List<Subject> findAllSubjects() {
		 Session session = HibernateUtil.getSessionFactory().openSession() ;
		 CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Subject> query = builder.createQuery(Subject.class);
         Root<Subject> root = query.from(Subject.class);
         query.select(root);
         Query<Subject> q=session.createQuery(query);
         List<Subject> subjectList=q.getResultList();
       
		session.close();
		return subjectList;
	}
	
	public static SubjectDao getInstance() {
		if (subjectDaoImpl == null)
			subjectDaoImpl = new SubjectDaoImpl();

		return subjectDaoImpl;
	}
 
}

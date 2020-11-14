package com.fl.school.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.fl.school.modal.Classroom;
import com.fl.school.util.HibernateUtil;


public class ClassroomDaoImpl implements ClassroomDao {
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private static ClassroomDaoImpl classroomDaoImpl = null;


	 
	public   void saveClass(Classroom classroom) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(classroom);
//		Classroom classroom1 = session.get(Classroom.class, classroom.getClassId());
//		Set<ClassSubject> classSubjects = classroom1.getClassSubject();
//		classSubjects.forEach(e -> session.persist(e));		 
		transaction.commit();
		session.close();		 
	}

	 
	public void updateClassroom(Classroom classroom) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(classroom);
		transaction.commit();
		session.close();
	}

	 
	public void deleteClassroom(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classroom classroom = session.get(Classroom.class, id);
//		Set<ClassSubject> classSubjects = classroom.getClassSubject();
//		//classroom.setClassSubject(null);
//		classSubjects.forEach(e -> session.remove(e));		 
		session.remove(classroom);
		Query<?> query = session.createQuery("delete from ClassSubject c where c.classId = :cId");
		query.setParameter("cId", id);
		query.executeUpdate();
		transaction.commit();
		session.close();

	}

	 
	public Classroom findClassroomById(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Classroom classroom = session.get(Classroom.class, id);
		transaction.commit();
		session.close();
		return classroom;

	}

	public List<Classroom> findAllClassrooms() {
			Session session = this.sessionFactory.openSession();		
			 CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Classroom> query = builder.createQuery(Classroom.class);
	         Root<Classroom> root = query.from(Classroom.class);
	         query.select(root);
	         Query<Classroom> q=session.createQuery(query);
	         List<Classroom> classroomList=q.getResultList();	       
			session.close();
			return classroomList;
	}
	
	
	public static ClassroomDao getInstance() {
		if (classroomDaoImpl == null)
			classroomDaoImpl = new ClassroomDaoImpl();

		return classroomDaoImpl;
	}
}

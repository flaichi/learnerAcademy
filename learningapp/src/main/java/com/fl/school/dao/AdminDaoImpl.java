package com.fl.school.dao;
 
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fl.school.exceptions.InvalidCredentialException;
import com.fl.school.modal.Admin;
import com.fl.school.util.HibernateUtil;


 
public class AdminDaoImpl implements AdminDao{

	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private static AdminDaoImpl adminDaoImpl = null;


	 
	public Long saveAdmin(Admin admin) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long) session.save(admin);
		transaction.commit();
		session.close();

		return id;
	}

	 
	public void updateAdmin(Admin admin) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(admin);
		transaction.commit();
		session.close();
	}
	
	
	public static AdminDao getInstance() {
		if (adminDaoImpl == null)
			adminDaoImpl = new AdminDaoImpl();

		return adminDaoImpl;
	}	
	
	
	public boolean validateLogin(String userName, String password) throws InvalidCredentialException{
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			TypedQuery<Admin> query = session.createQuery("from Admin a where a.username = :userName and a.password = : password",Admin.class);
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			
			Admin admin = query.getSingleResult();		
			
			if (admin != null) {
				return true;
			}
		} catch (Exception e) {
			
			throw new InvalidCredentialException("Username or Password is incorrect");
		}
		return false;
	}
	
}
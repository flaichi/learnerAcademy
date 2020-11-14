package com.fl.school.util;

import java.util.Properties;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.fl.school.modal.Admin;
import com.fl.school.modal.ClassSubject;
import com.fl.school.modal.Classroom;
import com.fl.school.modal.Student;
import com.fl.school.modal.Subject;
import com.fl.school.modal.Teacher;
import com.fl.school.modal.User;


public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3307/test_db?allowPublicKeyRetrieval=true&useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root123");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				//settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Admin.class);
				configuration.addAnnotatedClass(Classroom.class);
				configuration.addAnnotatedClass(Student.class);
				configuration.addAnnotatedClass(Teacher.class);
				configuration.addAnnotatedClass(Subject.class);
				configuration.addAnnotatedClass(ClassSubject.class);			
							

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				/*
				 * MetadataSources sources = new MetadataSources(serviceRegistry); Metadata
				 * metadata = sources.getMetadataBuilder().build(); sessionFactory =
				 * metadata.getSessionFactoryBuilder().build();
				 */
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				//return sessionFactory;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}

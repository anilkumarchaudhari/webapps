package com.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.model.Employee;

public class HibernateUtil {
 
	private static SessionFactory sessionFactory=null;
	
	static {
		sessionFactory=loadSessionfactory();
	}

	 @SuppressWarnings("deprecation")
	static SessionFactory loadSessionfactory() {
		  // sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		 Configuration cfg=new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 cfg.addAnnotatedClass(Employee.class);
		 ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		 sessionFactory=cfg.buildSessionFactory(srvcReg);
		 return sessionFactory;
	}
	 
	 public static Session getSession() {
		 Session session=null;
		 
		 try {
			  session=sessionFactory.openSession();

		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 return session;
	 }
}

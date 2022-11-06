package com.blurdel.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.blurdel.orm.util.HibernateUtil;


public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		
		
		s.getTransaction().commit();
		s.close();
		System.out.println("Done.");
		HibernateUtil.shutdown();
	}

}

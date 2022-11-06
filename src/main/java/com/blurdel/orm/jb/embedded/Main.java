package com.blurdel.orm.jb.embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.blurdel.orm.jb.embedded.Address;
import com.blurdel.orm.jb.embedded.User;
import com.blurdel.orm.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session s = sf.openSession();
		s.beginTransaction();
		
		// Testing embedded addresses
		User user = new User();
		user.setUsername("Zoey");
		user.setAge(15);
		Address ad1 = new Address();
		ad1.setStreet("28th ST");
		ad1.setCity("Arlington");
		ad1.setState("VA");
		ad1.setZip("22206");
		user.setAddress(ad1);
		
		Address ad2 = new Address();
		ad2.setStreet("VacaST");
		ad2.setCity("VacaCity");
		ad2.setState("VacaState");
		ad2.setZip("22206");
		user.setVacaAddress(ad2);
		
		s.save(user);
		
		user = new User();
		user.setUsername("Tana");
		user.setAge(5);
		s.save(user);
		
		s.getTransaction().commit();
		s.close();

		
		s = sf.openSession();
		User got = (User) s.get(User.class, 1);
		if (got != null) {
			System.out.println(got.toString());
		}
		s.close();
		
		System.out.println("Done.");
		HibernateUtil.shutdown();
	}

}

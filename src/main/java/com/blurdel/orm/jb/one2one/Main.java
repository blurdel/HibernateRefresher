package com.blurdel.orm.jb.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.blurdel.orm.util.HibernateUtil;


public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		
		Vehicle121 v1 = new Vehicle121();
		v1.setName("Jeep");
		Vehicle121 v2 = new Vehicle121();
		v2.setName("Honda");
		
		User121 user = new User121();
		user.setUsername("Zoey");
		user.setVehicle(v2);
		
		
		s.save(user);
		s.save(v1);
		s.save(v2);
		
		s.getTransaction().commit();
		s.close();

		
		s = sf.openSession();
		User121 got = (User121) s.get(User121.class, 1);
		if (got != null) {
			System.out.println(got.toString());
		}
		s.close();
		
		System.out.println("Done.");
		HibernateUtil.shutdown();
	}

}

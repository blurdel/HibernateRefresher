package com.blurdel.orm.jb.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.blurdel.orm.util.HibernateUtil;


public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		
		Vehicle12many v1 = new Vehicle12many();
		v1.setName("Jeep");
		Vehicle12many v2 = new Vehicle12many();
		v2.setName("Honda");
		
		User12many user = new User12many();
		user.setUsername("Zoey");
		
		user.getVehicle().add(v1);
		user.getVehicle().add(v2);
//		v1.setUser12m(user); // added last, bi-directional
//		v2.setUser12m(user); // added last, bi-directional
		
		s.persist(user);
//		s.save(v1);
//		s.save(v2);
		
		s.getTransaction().commit();
		s.close();

		
		s = sf.openSession();
		User12many got = (User12many) s.get(User12many.class, 1);
		if (got != null) {
			System.out.println(got.toString());
		}
		s.close();
		
		System.out.println("Done.");
		HibernateUtil.shutdown();
	}

}

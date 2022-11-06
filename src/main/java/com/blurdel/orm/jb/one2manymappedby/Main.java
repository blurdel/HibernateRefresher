package com.blurdel.orm.jb.one2manymappedby;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.blurdel.orm.util.HibernateUtil;


public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		
		Vehicle12manyMaped v1 = new Vehicle12manyMaped();
		v1.setName("Honda");
		Vehicle12manyMaped v2 = new Vehicle12manyMaped();
		v2.setName("Jeep");
		
		User12manyMaped user = new User12manyMaped();
		user.setUsername("Zoey");
		
		user.getVehicle().add(v1);
		user.getVehicle().add(v2);
		v1.setUser12m(user); // added last, bi-directional
		v2.setUser12m(user); // added last, bi-directional
		
		s.save(user);
		s.save(v1);
		s.save(v2);
		
		s.getTransaction().commit();
		s.close();

		
		s = sf.openSession();
		User12manyMaped got = (User12manyMaped) s.get(User12manyMaped.class, 1);
		if (got != null) {
			System.out.println(got.toString());
		}
		s.close();
		
		System.out.println("Done.");
		HibernateUtil.shutdown();
	}

}

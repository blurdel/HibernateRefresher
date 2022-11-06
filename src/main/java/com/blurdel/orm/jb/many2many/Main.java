package com.blurdel.orm.jb.many2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.blurdel.orm.util.HibernateUtil;


public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		
		Vehiclem2m v1 = new Vehiclem2m();
		v1.setName("Honda");
		Vehiclem2m v2 = new Vehiclem2m();
		v2.setName("Jeep");
		
		Userm2m user = new Userm2m();
		user.setUsername("Zoey");
		
		user.getVehicle().add(v1);
		user.getVehicle().add(v2);
		v1.getUsers().add(user);
		v2.getUsers().add(user);
		
		s.save(user);
		s.save(v1);
		s.save(v2);
		
		s.getTransaction().commit();
		s.close();

		
		s = sf.openSession();
		Userm2m got = (Userm2m) s.get(Userm2m.class, 1);
		if (got != null) {
			System.out.println(got.toString());
		}
		s.close();
		
		System.out.println("Done.");
		HibernateUtil.shutdown();
	}

}

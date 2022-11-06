package com.blurdel.orm.jb.embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.blurdel.orm.jb.embedded.Address;
import com.blurdel.orm.util.HibernateUtil;


public class MainColl {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		
		UserColl user = new UserColl();
		user.setUsername("Zoey");

		Address ad1 = new Address();
		ad1.setStreet("28th ST");
		ad1.setCity("Arlington");
		ad1.setState("VA");
		ad1.setZip("22206");
		
		Address ad2 = new Address();
		ad2.setStreet("VacaST");
		ad2.setCity("VacaCity");
		ad2.setState("VacaState");
		ad2.setZip("22206");

		user.getAddrList().add(ad1);
		user.getAddrList().add(ad2);
		
		
		s.beginTransaction();
		s.save(user);		
		s.getTransaction().commit();
		s.close();
		
		user = null; // test eager/lazy
		
		s = sf.openSession();
		user = (UserColl) s.get(UserColl.class, 1);
		s.close(); // test eager/lazy
		
		if (user != null) {
			System.out.println("size=" + user.getAddrList().size());
		}
		
		
		System.out.println("Done.");
		HibernateUtil.shutdown();
	}

}

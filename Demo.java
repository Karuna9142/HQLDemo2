package com.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Demo {

	public static void main(String[] args) {
		
		Configuration c = new Configuration();
		c.configure("hibernate.cfg.xml");
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
		Transaction t = s.beginTransaction();
		
		/*
		//way to  fetch a single one data from hql
		String hql = "from Student stud where stud.sid=:k";
		Query q = s.createQuery(hql);
		q.setParameter("k", 101);
		*/
		
		/*
		//Query to delete
		String hql = "delete from Student where sid=:i";
		Query q = s.createQuery(hql);
		q.setParameter("i", 102);
		int del =q.executeUpdate();                   // rows affected
        System.out.println(del + " record deleted");
        */
		
		//Query to delete all data
        String hql = "delete from Student";
		Query q = s.createQuery(hql);
		int del =q.executeUpdate();                   // rows affected
        System.out.println(del + " record deleted");
        
		
        List<Student> studlist =  q.getResultList();
		
		for(Student st :studlist)
		{
		   	System.out.println(st.getSid());
		   	System.out.println(st.getSname());
		   	System.out.println(st.getAge());
		   	System.out.println(st.getSaddress());
		   	System.out.println();  	
		}
		t.commit();
		s.close();

	}

}

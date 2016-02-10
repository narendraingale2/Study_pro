package com.spring_study.test;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring_study.model.Address;
import com.spring_study.model.Student;

public class Hibernate_Test {

	public static void main(String args[])
	{
		Student student = new Student();
		Address address= new Address();
		address.setCity("Pune");
		address.setCountry("Inda");
		address.setStreet("ABC");
		address.setZip("412303");
		student.setStudentName("Narendra");
		student.setAddress(address);
		student.setStudentContact(9657564542L);
		List <String> skillset = new LinkedList<String>();
		skillset.add("Java");
		skillset.add("Python");
		student.setSkillSet(skillset);
		student.setStudentHobby("Kabaddi");
		student.setStudentDOB(new Date("1989/05/05"));
		
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		 Transaction tx=session.beginTransaction();
		session.save(student);
		tx.commit();
		session.close();
		
		session=factory.openSession();
		session.beginTransaction();
		Student std=session.get(Student.class,1);
		System.out.print("This is the user "+std.getUserId());
		session.close();
		
		
		
		
		
	}
	
	
	
	
	
	
}

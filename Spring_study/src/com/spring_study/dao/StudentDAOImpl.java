package com.spring_study.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.transaction.annotation.Transactional;

import com.spring_study.model.Student;
@Transactional
public class StudentDAOImpl implements StudentDAO {

	public StudentDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}

	private SessionFactory sessionfactory;
	
	@Override
	public List<Student> list() {
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();
		Student exampleStudent=new Student();
				exampleStudent.setStudentName("Narendra");
		
		Example example=Example.create(exampleStudent);
		
		List<Student> std_list=null;
		Criteria criteria=session.createCriteria(Student.class);
		
		try{
			System.out.println("Creating list");
			std_list=(List<Student>) criteria.list();
			System.out.println("List has been created");
			 for(Student student1 : std_list) 
			 {
		            System.out.println(student1.getStudentName());
		            System.out.println(student1.getSkillSet());
			 }
			
		}catch(HibernateException e)
		{
			System.out.println("Error found something went wrong Narendra !!!!!!");
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return std_list;
	}

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.getCurrentSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();

	}

	@Override
	public void update(Student student) {
		Session session=sessionfactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(student);
		session.getTransaction().commit();


	}

	@Override
	public Student getStudent(int id) {
		Session session=sessionfactory.getCurrentSession();
		session.beginTransaction();
		Student std=session.get(Student.class,id);
		System.out.println(std.getSkillSet());
		session.getTransaction().commit();

		return std;
	}

	@Override
	public void delete(int id) {
		Session session=sessionfactory.getCurrentSession();
		session.beginTransaction();
		Student std=session.get(Student.class,id);
		session.delete(std);
		session.getTransaction().commit();

	


	}

}

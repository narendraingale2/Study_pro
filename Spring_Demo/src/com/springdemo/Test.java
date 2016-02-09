package com.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.Student;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Bean.xml");
		StudentDAO std= (StudentDAO) ctx.getBean("sdao");
		  int status=std.saveStudent(new Student(110,"Narendra",25));  
		    System.out.println(status);  
		 status=std.updateStudent(new Student(105, "XYZ", 23));
	}

}

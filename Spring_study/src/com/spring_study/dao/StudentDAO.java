package com.spring_study.dao;

import java.util.List;

import com.spring_study.model.Student;

public interface StudentDAO {
	
	    public List<Student> list();
	    public void add(Student student);
	    public void  update(Student student);
	    public Student  getStudent(int id);
	    public void  delete(int id);
	 

}

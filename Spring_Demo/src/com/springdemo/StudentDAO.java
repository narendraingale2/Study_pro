package com.springdemo;

import org.springframework.jdbc.core.JdbcTemplate;
import com.dao.*;

public class StudentDAO {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public int saveStudent(Student e){  
	    String query="insert into Student values(  '"+e.getId()+"','"+e.getName()+"','"+e.getAge()+"')";  
	    return jdbcTemplate.update(query);  
	}  
	
	public int updateStudent(Student e){  
	    String query="update Student set name='"+e.getName()+"',Age='"+e.getAge()+"' where id='"+e.getId()+"' ";  
	    return jdbcTemplate.update(query);  
	}  

	public int deleteStudent(Student e){
		String query="delete from Student where id="+e.getId()+" ";
		return jdbcTemplate.update(query);
		
	}
}

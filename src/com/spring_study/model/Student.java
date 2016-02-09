package com.spring_study.model;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity(name="Student")
public class Student {

@Id @GeneratedValue
private int userId;
private String studentName;
private String studentHobby;
private long studentContact;
private Date studentDOB;
@ElementCollection
private List<String> skillSet;

@OneToOne(cascade=CascadeType.ALL)
private Address address;
   
public Student() {
	
}
public long getStudentContact() {
	return studentContact;
}
public void setStudentContact(long studentContact) {
	this.studentContact = studentContact;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentHobby() {
	return studentHobby;
}
public void setStudentHobby(String studentHobby) {
	this.studentHobby = studentHobby;
}
public Date getStudentDOB() {
	return studentDOB;
}
public void setStudentDOB(Date studentDOB) {
	this.studentDOB = studentDOB;
}
public List<String> getSkillSet() {
	return skillSet;
}
public void setSkillSet(List<String> skillSet) {
	System.out.println("I am here at skillset");
	this.skillSet = skillSet;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	System.out.println("I am in set address");
	this.address = address;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}

}

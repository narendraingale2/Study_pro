package com.dao;


public class Student {
	
	public Student(int id, String name, float age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAge() {
		return age;
	}
	public void setAge(float age) {
		this.age = age;
	}
	private String name;
	private float age;

}

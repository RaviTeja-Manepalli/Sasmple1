package com.mindtree.passport.entity;

public class Person {
	private String id;
	private String name;
	private String birthplace;
	private int age;
	private Passport pass;

	public Person() {
		super();
	}

	public Person(String id, String name, String birthplace, int age) {
		super();
		this.id = id;
		this.name = name;
		this.birthplace = birthplace;
		this.age = age;
	}

	public Person(Passport p) {
		super();
		this.pass = p;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Passport getPass() {
		return pass;
	}

	public void setPass(Passport p) {
		this.pass = p;
	}

}

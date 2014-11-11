package com.example.servletjspdemo.domain;


public class Person {
	
	private String name = "";
	private String surname = "";
	private Sex sex = Sex.male;
	//private Enumeration<Hobby> hobbies;
	private Hobby hobby = Hobby.sport;
	private String description = "";
	private Education education = Education.srednie;
	
	public Person() {
		super();
	}
	
	
	public Person(String name, String surname, Sex sex,
			Hobby hobby, String opis, Education education) {
		super();
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.hobby = hobby;
		this.description = opis;
		this.education = education;
	}

	public String toString() {
		return name + " " + surname + " " + sex.toString() + " " + hobby.toString() + " " + description + " " + education.toString();
 	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	public Hobby getHobby() {
		return hobby;
	}

	public String getOpis() {
		return description;
	}

	public void setOpis(String opis) {
		this.description = opis;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}


	public enum Sex { male, female }
	
	public enum Hobby { tv, sport }
	
	public enum Education { gimnazjalne, zawodowe, srednie, policealne, wyzsze }
}

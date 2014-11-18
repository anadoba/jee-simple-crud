package com.example.servletjspdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.servletjspdemo.domain.Person;

public class StorageService {
	
	private List<Person> db = new ArrayList<Person>();
	
	public void add(Person person) {
		//Person newPerson = new Person(person.getName(), person.getSurname(), person.getSex(), person.getHobby(), person.getOpis(), person.getEducation());
		db.add(person);
	}
	
	public List<Person> getAllPersons(){
		return db;
	}
	
	public String getAllPersonsInHTML() {
		StringBuilder sb = new StringBuilder();
		
		for (Person person : db) {
			sb.append(person.toString() + "<br>");
		}
		
		return sb.toString();
	}

}

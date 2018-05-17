package com.example.demo;

import java.util.Collection;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
	PersonDaoImpl personDaoImpl;
	/*Hashtable<String, Person> ht=new Hashtable<>();
	public PersonService() {
		Person p=new Person("1","Aayushi","Jain",21);
		Person p1=new Person("2","Megha","Jain",21);
		Person p2=new Person("3","Aashima","Jain",21);
		ht.put("1",p);
		ht.put("2",p1);
		ht.put("3",p2);
	}

	public Hashtable<String,Person> getAllPersons(){
		return ht;
	}

	public Person getPerson(String id) {
		return ht.get(id);
	}*/
	
	public Collection<Person> getAllPersons(){
		return personDaoImpl.findAllPersons();
	}
	
	public Person getpersonById(String id) {
		return personDaoImpl.getPersonById(id);
		
	}
		public int deleteperson(String id) {
			return personDaoImpl.deletePersonById(id);
		}
		public void addPerson(Person person) {
			personDaoImpl.insertPerson(person);
		} 
		public void updateperson(Person p) {
			 personDaoImpl.updatePerson(p);
		}
}
 
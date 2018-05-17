package com.example.demo;

import java.util.Collection;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	PersonService pservice;

	@RequestMapping("/all")
	public Collection<Person> getAll(){
		return pservice.getAllPersons();
	}
	
	@RequestMapping("{id}")
	public Person getID(@PathVariable("id") String id) {
		return pservice.getpersonById(id);
	}
	@RequestMapping("/delete/{id}")
	public int delete(@PathVariable("id") String id) {
		return pservice.deleteperson(id);
	}
	@RequestMapping("/add")
	public Person addPerson(@RequestBody Person person) {
		System.out.println("id"+person.getId());
		pservice.addPerson(person);
		return person;
	} 
	
	@RequestMapping("/update/{id}")
	public Person update(@RequestBody Person p,@PathVariable("id") String id) {
		 pservice.updateperson(p);
		 return p;
	}

	/*@RequestMapping("{id}")
	public Person getPerson(@PathVariable ("id") String id) {
		return pservice.getPerson(id);
	}*/
}
package com.example.demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Collection<Person> findAllPersons(){
		
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person getPersonById(String id) {
		return jdbcTemplate.queryForObject("select * from person where id=?",
				new BeanPropertyRowMapper<Person>(Person.class),id);
	}
	
	public int deletePersonById(String id) {
		return jdbcTemplate.update("delete from person where id=?",id);
	}
	
	public void insertPerson(Person person) {
		String sql="insert into person values(?,?,?,?)";
		jdbcTemplate.update(sql,person.getId(),person.getFirstName(),person.getLastName(),person.getAge());

	} 
	
	public void updatePerson(Person person) {
		String sql="update person set firstname=?,lastname=?,age=? where id=?";
		 jdbcTemplate.update(sql,person.getFirstName(),person.getLastName(),person.getAge(),person.getId());
	}
}

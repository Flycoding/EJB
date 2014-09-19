package com.flyingh.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.flyingh.ejb.entity.Person;

@Remote
public interface PersonServiceRemote {
	void add(Person person);

	void update(Person person);

	void delete(int id);

	Person find(int id);

	List<Person> findAll();
}

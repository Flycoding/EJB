package com.flyingh.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.flyingh.ejb.entity.Person;

@Stateless
public class PersonService implements PersonServiceRemote, PersonServiceLocal {
	@PersistenceContext(name = "ejb")
	private EntityManager em;

	@Override
	public void add(Person person) {
		em.persist(person);
	}

	@Override
	public void update(Person person) {
		em.merge(person);
	}

	@Override
	public void delete(int id) {
		em.remove(em.getReference(Person.class, id));
	}

	@Override
	public Person find(int id) {
		return em.find(Person.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findAll() {
		return em.createQuery("from Person").getResultList();
	}

}

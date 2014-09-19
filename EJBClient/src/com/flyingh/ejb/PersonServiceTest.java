package com.flyingh.ejb;

import java.util.List;

import javax.naming.InitialContext;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.flyingh.ejb.entity.Person;

public class PersonServiceTest {
	private static PersonServiceRemote personService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		final InitialContext context = new InitialContext();
		personService = (PersonServiceRemote) context.lookup("PersonService/remote");
	}

	@Test
	public void testAdd() {
		personService.add(new Person("Abc"));
	}

	@Test
	public void testUpdate() {
		final Person person = personService.find(1);
		person.setName("Flycoding");
		personService.update(person);
	}

	@Test
	public void testDelete() {
		personService.delete(2);
	}

	@Test
	public void testFind() {
		System.out.println(personService.find(1));
	}

	@Test
	public void testFindAll() {
		final List<Person> persons = personService.findAll();
		for (final Person person : persons) {
			System.out.println(person);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		personService = null;
	}

}

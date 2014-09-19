package com.flyingh.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class HelloEJB implements HelloEJBRemote, HelloEJBLocal {
	@EJB
	private OtherLocal other;

	@Override
	public String sayHello(String name) {
		return "Hello," + name + "," + other.say();
	}
}

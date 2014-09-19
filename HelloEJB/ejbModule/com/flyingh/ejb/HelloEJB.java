package com.flyingh.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloEJB implements HelloEJBRemote, HelloEJBLocal {

	@Override
	public String sayHello(String name) {
		return "Hello," + name;
	}
}

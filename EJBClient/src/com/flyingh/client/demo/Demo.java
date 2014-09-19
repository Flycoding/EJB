package com.flyingh.client.demo;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.flyingh.ejb.HelloEJBRemote;

public class Demo {
	public static void main(String[] args) throws NamingException {
		final HelloEJBRemote helloEJB = (HelloEJBRemote) new InitialContext().lookup("HelloEJB/remote");
		System.out.println(helloEJB.sayHello("Flycoding"));
	}
}

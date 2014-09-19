package com.flyingh.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloEJBRemote {
	String sayHello(String name);
}

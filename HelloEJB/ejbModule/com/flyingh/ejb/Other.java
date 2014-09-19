package com.flyingh.ejb;

import javax.ejb.Stateless;

@Stateless
public class Other implements OtherLocal {

	@Override
	public String say() {
		return "Other";
	}
}

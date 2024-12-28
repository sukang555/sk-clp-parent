package com.skse.se.javagrammar.annocation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnocation {
	
	public String name();
	
	public String value();

}

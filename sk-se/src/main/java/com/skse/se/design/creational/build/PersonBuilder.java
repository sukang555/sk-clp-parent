package com.skse.se.design.creational.build;

public class PersonBuilder {
	
	private String head;
    
    private String body;
    
    private String foot;

	public PersonBuilder setHead(String head) {
		this.head = head;
		return this;
	}
	
	public PersonBuilder setBody(String body) {
		this.body = body;
		return this;
	}
	
	public PersonBuilder setFoot(String foot) {
		this.foot = foot;
		return this;
	}
	
	public static PersonBuilder create(){
		return new PersonBuilder();
	}

	public Person build(){
    	return new Person(head,body,foot);
    }

}

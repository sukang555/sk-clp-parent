package com.skse.se.design.creational.build;

public class Person {

    private String head;
    
    private String body;
    
    private String foot;
    
    

    public Person(String head, String body, String foot) {
		super();
		this.head = head;
		this.body = body;
		this.foot = foot;
	}

	public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

	@Override
	public String toString() {
		return "Person [head=" + head + ", body=" + body + ", foot=" + foot + "]";
	}
    
   
}


package com.skse.se.design.behavioral.listen;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Test;

//观察者设计模式

/**
 * 抽象观察者
 * @author hand
 *
 */
interface Observer {
	
	public void  update(String name);

}

interface Subject{
	
	public void addObserver(Observer observer);
	
	public void removeObserver(Observer observer);
	
	public void notifyAllObserver(String info);
}


class TeacherSubject implements Subject {
	
	List<Observer> list = new ArrayList<>();
	

	@Override
	public void addObserver(Observer observer) {
		Objects.requireNonNull(observer);
		this.list.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		if (list.contains(observer)) {
			this.list.remove(observer);
		}
	}

	@Override
	public void notifyAllObserver(String info) {
		for (Observer observer : this.list) {
			observer.update(info);
		}
		
	}
	
	
	public void setHomework(String info){
		
		System.out.println("今天的作业是" + info);
		notifyAllObserver(info);
	}
	
}


class StudentSubject implements Observer {
	
	private String name;
	private Subject teacherSubject;
	
	
	public StudentSubject(String name, Subject teacherSubject) {
		this.setName(name);
		this.setTeacherSubject(teacherSubject);
		teacherSubject.addObserver(this);
	}

	@Override
	public void update(String info) {
		System.out.println(name + ":" + info);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject getTeacherSubject() {
		return teacherSubject;
	}

	public void setTeacherSubject(Subject teacherSubject) {
		this.teacherSubject = teacherSubject;
	}


	
	
}


public class TestSubject{
	
	
	
	@Test
	public void main1() {
		TeacherSubject teacherSubject = new TeacherSubject();
		
		new StudentSubject("AA", teacherSubject);
		new StudentSubject("BB", teacherSubject);
		new StudentSubject("CC", teacherSubject);
		
		teacherSubject.setHomework("第二页第六题");
	}
}






































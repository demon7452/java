package com.charpter5.abstractClass;

public class Student extends Person{

    public Student(String name) {
	super(name);
	// TODO Auto-generated constructor stub
    }

    @Override
    public String getDescription() {
	return "a student name is " + getName();
    }

}

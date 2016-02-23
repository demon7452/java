package com.charpter5.abstractClass;

public class Employee extends Person {

    public Employee(String name) {
	super(name);
	// TODO Auto-generated constructor stub
    }

    @Override
    public String getDescription() {
	return "an employee name is " + getName();
    }

}

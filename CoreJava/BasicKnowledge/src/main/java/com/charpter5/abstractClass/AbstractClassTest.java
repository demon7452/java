package com.charpter5.abstractClass;
public class AbstractClassTest {

    public static void main(String[] args) {
	Person[] persons = new Person[3];
	

	 persons[0] = new Person("hello") {
	    
	    @Override
	    public String getDescription() {
		// TODO Auto-generated method stub
		return "null";
	    }
	};
	
	persons[1] = new Student("A",11);
	persons[2] = new Employee("B");
	for(Person person : persons)
	{
	    System.out.println(person.getDescription());
	    System.out.println(person.toString());
	    System.out.println("the current position is "+person);
	}
    }

}

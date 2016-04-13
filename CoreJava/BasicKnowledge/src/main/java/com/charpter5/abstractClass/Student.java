package com.charpter5.abstractClass;

public class Student extends Person{

	private int studentId;
    public Student(String name,int studentId) {
    	super(name);
    	this.studentId = studentId;
    }

    @Override
    public String getDescription() {
	return "a student name is " + getName();
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + studentId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentId != other.studentId)
			return false;
		return true;
	}
	@Override
	public String toString(){
		return getClass().getName()+"[studentId:"+studentId+",name:"+getName()+"]";
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}

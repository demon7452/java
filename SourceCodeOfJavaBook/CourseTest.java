public class CourseTest
{
	public static void main(String[] args)
	{
		Course course1=new Course("Data Structures");
		Course course2=new Course("Database Systems");

		course1.addStudent();
		course2.addStudent();

		System.out.println("the number of students in coures "+course1.getName()+" is "+course1.getNumberOfStudents()+"\nand the students are:");
		course1.getStudents();
		System.out.println("\nthe number of students in coures "+course2.getName()+" is "+course2.getNumberOfStudents()+"\nand the students are:");
		course2.getStudents();
	}
}

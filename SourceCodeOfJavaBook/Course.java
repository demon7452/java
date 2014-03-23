import javax.swing.JOptionPane;
public class Course
{
	private String name;
	private String[] students=new String[100];
	private int numberOfStudents;

	public Course(String name)
	{
		this.name=name;
		numberOfStudents=0;
	}
	public String getName()
	{
		return name;
	}
	public void getStudents()
	{
		for(int i=0;i<numberOfStudents;i++)
		{
			if((i+1)%4==0)
				System.out.printf("%-12s\n",students[i]);
			else
				System.out.printf("%-12s",students[i]);
		}
		System.out.println();
	}
	public void addStudent()
	{
		int option=0;
		while(option==JOptionPane.YES_OPTION)
		{
			String studentName=JOptionPane.showInputDialog("enter the student name of "+name);
			students[numberOfStudents]=studentName;
			numberOfStudents++;
			option=JOptionPane.showConfirmDialog(null,"do you want to add student once more?");
		}
	}
	public int getNumberOfStudents()
	{
		return numberOfStudents;
	}

}

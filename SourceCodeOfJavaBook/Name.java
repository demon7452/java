public final class Name implements Comparable
{
	private String firstName;
	private char mi;
	private String lastName;

	public Name(String firstName,char mi,String lastName)
	{
		this.firstName=firstName;
		this.mi=mi;
		this.lastName=lastName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public char getMi()
	{
		return mi;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getFullname()
	{
		return firstName+" "+mi+" "+lastName;
	}
	public int compareTo(Object o)
	{
		if(!lastName.equals(((Name)o).lastName))
			return lastName.compareTo(((Name)o).lastName);
		else if(!firstName.equals(((Name)o).firstName))
			return firstName.compareTo(((Name)o).firstName);
		else 
			return mi-((Name)o).mi;
	}
}

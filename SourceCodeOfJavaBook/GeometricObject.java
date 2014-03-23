public abstract class GeometricObject
{
	private String color="white";
	private boolean filled;
	private java.util.Date dateCreated;

	public GeometricObject()
	{
		dateCreated=new java.util.Date();
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color=color;
	}
	public boolean isFilled()
	{
		return filled;
	}
	public void setFilled(boolean filled)
	{
		this.filled=filled;
	}
	public String getDateCreated()
	{
		return dateCreated.toString();
	}
	public String toString()
	{
		return "created on "+getDateCreated()+"\ncolor: "+color+" and filled: "+filled;
	}
	public abstract double getArea();
	public abstract double getPerimeter();
}

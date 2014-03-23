import java.sql.*;
public class DBOperation
{
	public static void main(String[] args)
	{
		 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		 String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=test";
		 String userName="lixi";
		 String userPwd="1234";
		 Connection dbConn;
		try
		{
			Connection conn=null;
			String url="jdbc:sqlserver://localhost:1433;DatabaseName=test";
			String user="lixi";
			String password="1234";
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("connecton success");
			conn.close();
		}
		catch (Exception e)
		{
			System.out.println("connection failure");
		}
	}
}
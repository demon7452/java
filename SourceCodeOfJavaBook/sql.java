import java.sql.*;
public class sql
{
	public static void main(String args[])
	{
		String url="jdbc:odbc:sqlserver";
		Connection con;
		Statement stmt;
		String query="select * from col_link";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch(java.lang.ClassNotFoundException e)
		{
			System.err.print("ClassNotFoundException:");
			System.err.println(e.getMessage());
		}
		try
		{
			con=DriverManager.getConnection(url,"sa","");
			stmt=con.createStatement();
			stmt.executeUpdate("CREATE TABLE col_link(sitename varchar(20) NULL,siteurl varchar(50) NULL)");
			stmt.executeUpdate("insert into col_link values('ASP','http://www.asp.cn')");
			stmt.executeUpdate("insert into col_link values('YONGYUAN','http://www')");
			
			ResultSet rs=stmt.executeQuery(query);
		    System.out.println("col_link���е��������£�ԭʼ���ݣ�");
		    System.out.println("վ����"+""+"վ���ַ");
		    System.out.println("--------"+""+"---------");
		    while (rs.next())
		    {
		    	String s=rs.getString("sitename");
		    	String f=rs.getString("siteurl");
		        System.out.println(s+""+f);
		    }
		    stmt.close();
		    con.close();
		}
		catch(SQLException ex)
		{
			System.err.println("SQLException:"+ex.getMessage());
		}
	}
}
//���뿪ʼ

//###########################################################

import java.sql.*;

//����java�������Ӱ���java�������е����ݿ�ĵ��õĶ��������������

public class InsertCoffees {

public static void main(String args[]) {

String url = "jdbc:odbc:sqlserver";

//ȡ�����ӵ�url����ע��sqlserver��dsn��

Connection con;

//ʵ����һ��Connection����

Statement stmt;

String query = "select * from col_link";

//ѡ�����е�Col_link���е��������

try {

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

//����jdbc-odbc������

} catch(java.lang.ClassNotFoundException e) {

System.err.print("ClassNotFoundException: ");

//����jdbc-odbc�Ŵ���

System.err.println(e.getMessage());

//��������

}

try {

con = DriverManager.getConnection(url, "sa", "");

//���ݿ�����

stmt = con.createStatement();

//Create һ������

stmt.executeUpdate("CREATE TABLE col_link (sitename varchar (20) NULL ,siteurl varchar (50) NULL) ");

//ִ����һ��sql���������һ����col_link�ı�

stmt.executeUpdate("insert into col_link values('ASP�л���','http://www.aspcn.com')");

stmt.executeUpdate("insert into col_link values('��Զ�����ж�Զ','http://xuankong.com')");

//ִ��һ��insert into���

stmt.executeUpdate("update col_link set siteurl='http://www.aspcn.com/xuankong/xuankongt.jpg' where siteurl='http://xuankong.com'");

//ִ��һ��update��䣬�������ݿ�

ResultSet rs = stmt.executeQuery(query);

//����һ�������

System.out.println("Col_link���е���������(ԭʼ����)");

//��������ʹ����һ��whileѭ����ӡ����col_link���е����е�����

System.out.println("վ���� "+" "+"վ���ַ");

System.out.println("---------------"+" "+"----------------");

while (rs.next()) {

String s = rs.getString("sitename");

String f = rs.getString("siteurl");

//ȡ�����ݿ��е�����

System.out.println(s + " " + f);

/*String t = rs.getString(1);

String l = rs.getString(2);

System.out.println(t + " " + l);*/

/*jdbc�ṩ�����ַ���ʶ���ֶΣ�һ����ʹ��getXXX(ע�������getXXX��ʾȡ��ͬ�����ֶεĲ�ͬ�ķ���)����ֶ�����

�ڶ���*��ͨ���ֶ��������������Ұѵڶ��ַ���ע����*/

/*����Է���������ӻ��getxxx���÷���http://java.sun.com/docs/books/tutorial/jdbc/basics/_retrievingTable.html*/

}

stmt.close();

con.close();

//��������ر�����������

} catch(SQLException ex) {

System.err.println("SQLException: " + ex.getMessage());

//��ʾ���ݿ����Ӵ�����߲�ѯ����

}

}

}
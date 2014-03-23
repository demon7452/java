//代码开始

//###########################################################

import java.sql.*;

//加载java数据连接包，java基本所有的数据库的调用的都在这个东西里面

public class InsertCoffees {

public static void main(String args[]) {

String url = "jdbc:odbc:sqlserver";

//取得连接的url名，注意sqlserver是dsn名

Connection con;

//实例化一个Connection对象

Statement stmt;

String query = "select * from col_link";

//选择所有的Col_link表中的数据输出

try {

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

//加载jdbc-odbc桥驱动

} catch(java.lang.ClassNotFoundException e) {

System.err.print("ClassNotFoundException: ");

//加载jdbc-odbc桥错误

System.err.println(e.getMessage());

//其他错误

}

try {

con = DriverManager.getConnection(url, "sa", "");

//数据库连接

stmt = con.createStatement();

//Create 一个声明

stmt.executeUpdate("CREATE TABLE col_link (sitename varchar (20) NULL ,siteurl varchar (50) NULL) ");

//执行了一个sql语句生成了一个表col_link的表

stmt.executeUpdate("insert into col_link values('ASP中华网','http://www.aspcn.com')");

stmt.executeUpdate("insert into col_link values('永远到底有多远','http://xuankong.com')");

//执行一个insert into语句

stmt.executeUpdate("update col_link set siteurl='http://www.aspcn.com/xuankong/xuankongt.jpg' where siteurl='http://xuankong.com'");

//执行一个update语句，更新数据库

ResultSet rs = stmt.executeQuery(query);

//返回一个结果集

System.out.println("Col_link表中的数据如下(原始数据)");

//下面的语句使用了一个while循环打印出了col_link表中的所有的数据

System.out.println("站点名 "+" "+"站点地址");

System.out.println("---------------"+" "+"----------------");

while (rs.next()) {

String s = rs.getString("sitename");

String f = rs.getString("siteurl");

//取得数据库中的数据

System.out.println(s + " " + f);

/*String t = rs.getString(1);

String l = rs.getString(2);

System.out.println(t + " " + l);*/

/*jdbc提供了两种方法识别字段，一种是使用getXXX(注意这里的getXXX表示取不同类型字段的不同的方法)获得字段名，

第二种*是通过字段索引，在这里我把第二种方法注释了*/

/*你可以访问这个连接获得getxxx的用法：http://java.sun.com/docs/books/tutorial/jdbc/basics/_retrievingTable.html*/

}

stmt.close();

con.close();

//上面的语句关闭声明和连接

} catch(SQLException ex) {

System.err.println("SQLException: " + ex.getMessage());

//显示数据库连接错误或者查询错误

}

}

}
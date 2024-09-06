import java.sql.*;
public class jdbctrail {
    jdbctrail() throws SQLException,ClassNotFoundException
    { 
    try
    {

        String url="jdbc:oracle:thin:@localhost:1521:XE";
        String user="system";
        String pass="1234";

        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection(url,user,pass);  
        Statement stmt=con.createStatement(); 
        stmt.executeUpdate("create table student2(sno int,name varchar(20))");
    	System.out.println("Table Created Sucessfully");
    }
    catch(Exception e){
        System.out.println(e);
    }
    }
    // public static void Create(Statement stmt)throws SQLException
    // {

    //     stmt.executeQuery("create table student4(hno varchar2(10),sname varchar2(20),course varchar2(15),fee number(8) )");
    // 	System.out.println("Table Created Sucessfully");
    // }
}

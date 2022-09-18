import java.sql.*;  
public class connection{  

public static Connection Conn(){ 
	Connection con = null;
  try{  
   //step1 load the driver class  
   Class.forName("oracle.jdbc.driver.OracleDriver");  
  
   //step2 create  the connection object  
    con = DriverManager.getConnection(  
   "jdbc:oracle:thin:@localhost:1521:orcldb","abc","1234"); 
  
  
  }catch(Exception e){ 
	  System.out.println("not connected");
   System.out.println(e);
  }  
  return con;
 } 
}
package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;

public class JDBCconnection {
	public static void main(String[] args) throws SQLException {
		Connection	conn=null;
		try {
		//step 1: load /regiter the database driver
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2: connect to database
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("=====Done============");
		
		//step 3: create sql statement
		Statement stat=conn.createStatement();
		
		//Execute select query and get result
		ResultSet resultset= stat.executeQuery("select * from project");
		
		while(resultset.next())
				{
			
			System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4)+ "\t"+ resultset.getString(5));
				
				}
		}
		catch(Exception e) {
			System.out.println("handle exception");
		}
		finally {
		//step 5: close the connection
		conn.close();
		System.out.println("close the database");
		}
		
	}

}

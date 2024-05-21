package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQuery {
	public static void main(String[] args) throws SQLException
	{
		//step 1: load /regiter the database driver
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2: connect to database
	Connection	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("=====Done============");
		
		//step 3: create sql statement
		Statement stat=conn.createStatement();
		
		//Execute select query and get result
		int result= stat.executeUpdate("insert into project values('Proj_02', 'monisha', '01-03-24', 'amazon', 'Ongoing', '11');");
		if(result==1)
		{
			System.out.println("updated");
		}
		
				
		//step 5: close the connection
		conn.close();
		
		
	}

}


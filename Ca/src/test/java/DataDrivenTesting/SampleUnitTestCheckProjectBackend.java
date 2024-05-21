
package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjectBackend {
	@Test
	public void projectCheckTest() throws SQLException
	{
		String expectedProjectName="Flipkart_01";
		boolean flag= false;
		
		//step 1: load /regiter the database driver
				Driver driverRef= new Driver();
				DriverManager.registerDriver(driverRef);
				
				//step 2: connect to database
			Connection	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
				System.out.println("=====Done============");
				
				//step 3: create sql statement
				Statement stat=conn.createStatement();
				
				//step 4: execute select query and get result
			ResultSet resultset=	stat.executeQuery("select *from project");
			while(resultset.next())
			{
				String actProjectName=resultset.getString(4);
				if(expectedProjectName.equals(actProjectName))
				{
					flag=true;
					System.out.println(expectedProjectName+" is available==PASS");
				}
			}
			if(flag==false)
			{
				System.out.println(expectedProjectName+"is not available==FAIL");
			}
	}

}

package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class CreateProjectAndVerifyData {
	public static void main(String[] args) throws InterruptedException, SQLException {
		String projectName="Insta_5";		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://106.51.90.215:8084/");
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("manisha");
	Select sel= new Select(	driver.findElement(By.name("status")));
	sel.selectByIndex(0);
	driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	
	
	//verify the project in db(backend using jdbc)
	boolean flag=false;
	Driver  driverRef= new Driver();
	DriverManager.registerDriver(driverRef);
Connection	conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
	System.out.println("=====Done============");
	Statement stat=conn.createStatement();
ResultSet resultset=stat.executeQuery("select *from project");
while(resultset.next())
{
	String actProjectName=resultset.getString(4);
	if(projectName.equals(actProjectName))
	{
		flag=true;
		System.out.println(projectName+" is available in db==PASS");
	}
}
if(flag==false)
             {
	         System.out.println(projectName+"is not available in db ==FAIL");
             }
conn.close();
             }	
	}



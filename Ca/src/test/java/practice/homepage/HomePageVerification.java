package practice.homepage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageVerification {
	@Test
	public void homePageTest()//Method mtd)  //Method is a class in java
	{
		//System.out.println(mtd.getName()+"Test Start");
		String expectedPage= "Home Page";
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();

	//use xpath because there is space along with text[LinkText will not work]
	
String	actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
System.out.println(actTitle);

//Using java if else statement
if(actTitle.equals(expectedPage)) {
	System.out.println(expectedPage+"Page is verified== Pass");
}
else {
	System.out.println(expectedPage+"Page is  not verified== Fail");
}
driver.close();
//System.out.println(mtd.getName()+"Test end");
	}

	@Test
	public void verifyLogoHomePage() {
		//System.out.println(mtd.getName()+"Test Start");	
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status =driver.findElement(By.xpath("//img[@src='test/logo/vtiger-crm-logo.gif']")).isEnabled();
		if (status) {
		System.out.println("Logo is verified==Pass");
		}
		else
		{
			System.out.println("Logo is not verified==Fail");
		}
		driver.close();
		
		//System.out.println(mtd.getName()+"Test end");
	}
}

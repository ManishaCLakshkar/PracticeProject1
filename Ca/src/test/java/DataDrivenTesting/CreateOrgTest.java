package DataDrivenTesting;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//read commondata from properties
		FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\Desktop\\Data\\commondata1.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser= p.getProperty("browser");
	String	url =p.getProperty("url");
	String	username =p.getProperty("username");
	String	password =p.getProperty("password");
	
	
//read testscriptdata from excel
	FileInputStream fis1 = new FileInputStream("C:\\Users\\lenovo\\Desktop\\Data\\testscript1.xlsx");
Workbook wb=	WorkbookFactory.create(fis1);
wb.getSheet("org").getRow(0).getCell(1).getStringCellValue();
	WebDriver driver =null;
	if(browser.equals("chrome"))
	{
	driver= new ChromeDriver();	
	}
	else if(browser.equals("firefox"))
	{
		driver= new ChromeDriver();	
	}
	else if(browser.equals("edge")) {
		driver= new ChromeDriver();	 
	}
	//step 1:Login to the app
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys("username");
	driver.findElement(By.name("user_password")).sendKeys("password");
	driver.findElement(By.id("submitButton")).click();
	//step 2: navigate to the organisation module
	driver.findElement(By.linkText("Organisations")).click();
	//step 3: click on "create Organisation Button"
	driver.findElement(By.xpath("//img[@title='Create Organisation...']")).click();
	//step 4: enter all the deails and create new orgnisation
	driver.findElement(By.name("accountname")).sendKeys("facebook");
	//step 5: logout
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();
	}

}

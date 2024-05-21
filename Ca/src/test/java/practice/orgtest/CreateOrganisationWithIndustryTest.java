package practice.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganisationWithIndustryTest {
 public static void main(String[] args) throws Throwable {

	//read commondata from properties
	
	 FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\Desktop\\Data\\commondata1.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser= p.getProperty("browser");
	String	url =p.getProperty("url");
	String	username =p.getProperty("username");
	String	password =p.getProperty("password");
	
	//generate Random number
	Random r = new Random();
	int randomint=	r.nextInt(1000);

//read testscriptdata from excel
FileInputStream fis1 = new FileInputStream("C:\\Users\\lenovo\\Desktop\\Data\\testscript1.xlsx");
Workbook wb=	WorkbookFactory.create(fis1);
Sheet sh =wb.getSheet("org");
Row row =sh.getRow(7);
String orgName =row.getCell(2).toString() + randomint;
String phoneNumber =row.getCell(3).toString() ;

wb.close();

 
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
driver.findElement(By.name("user_name")).sendKeys(username);
driver.findElement(By.name("user_password")).sendKeys(password);
driver.findElement(By.id("submitButton")).click();

//step 2: navigate to the organisation module
driver.findElement(By.linkText("Organizations")).click();

//step 3: click on "create Organisation Button"
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//step 4: enter all the details and create new orgnisation
driver.findElement(By.name("accountname")).sendKeys(orgName);
driver.findElement(By.id("phone")).sendKeys(phoneNumber);

driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();Thread.sleep(2000);

Actions act = new Actions(driver);
act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();Thread.sleep(2000);
driver.findElement(By.xpath("//a[text()='Sign Out']")).click();Thread.sleep(2000);
  

     //Verify the header phone Number
String actPhoneNumber=driver.findElement(By.id("dtlview_Phone")).getText();
  if(actPhoneNumber.contains(phoneNumber)) {
	  System.out.println(phoneNumber+ "information is created=== PASS");
  }
  else {
	  System.out.println(phoneNumber+ "information is not created=== Fail");
  }
  
  
//step 5: logout
driver.quit();

}
}


package practice.contactTest;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactTest {
	public static void main(String[] args) throws Throwable {
		//Step 1: read commondata from properties
		
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
	String orgName =wb.getSheet("contacts").getRow(7).getCell(2).toString()+randomint;
	String lastName =wb.getSheet("contacts").getRow(7).getCell(2).toString();
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
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
		
	//step 2: navigate to the contacts module
	driver.findElement(By.linkText("Contacts")).click();

	//step 3: click on "create Organisation Button"
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

	//step 4: enter all the detAails and create new Contact.
	driver.findElement(By.name("lastname")).sendKeys(lastName);
	driver.findElement(By.xpath("//input[@title = 'Save [Alt+S']")).click();
	
	//verify header phone number info expected result
	 String  actlastName=driver.findElement(By.id("dtlview_LastName")).getText();
	  if(actlastName.contains(lastName)) {
		  System.out.println(lastName+ "is created=== PASS");
	  }
	  else {
		  System.out.println(lastName+ "is not created=== PASS");
	  }

	
	//step 5: logout
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	driver.findElement(By.linkText("Sign Out")).click();

	


	driver.quit();
	}
}


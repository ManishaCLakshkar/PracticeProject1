package practice.contactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class CreateContactWithSupportDateTest {
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
	Row row =sh.getRow(0);
	String lastName =row.getCell(2).toString() + randomint;
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
	driver.findElement(By.name("user_name")).sendKeys("username");
	driver.findElement(By.name("user_password")).sendKeys("password");
	driver.findElement(By.id("submitButton")).click();
		
	//step 2: navigate to the contacts module
	driver.findElement(By.linkText("Contacts")).click();

	//step 3: click on "create Organisation Button"
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

	//step 4: enter all the deails and create new Contact.
	Date dateObj= new Date();
	SimpleDateFormat sim =new SimpleDateFormat("yyyy-MM-dd");
    String startDate= sim.format(dateObj);
    
    Calendar cal= sim.getCalendar();
cal.add(Calendar.DAY_OF_MONTH, -30);
String endDate= sim.format(cal.getTime());
    
	driver.findElement(By.name("lastname")).sendKeys(lastName);
	driver.findElement(By.name("support_start_date")).clear();
	driver.findElement(By.name("support_start_date")).sendKeys(startDate);
	
	driver.findElement(By.name("support_end_date")).clear();
	driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	
	driver.findElement(By.xpath("//input[]@title = 'Save [Alt+S']")).click();
	
	//verify header phone number info expected result
	 String  actlastName=driver.findElement(By.id("dtlview_LastName")).getText();
	  if(actlastName.contains(lastName))
	  {
		  System.out.println(lastName+ "is created=== PASS");
	  }
	  else {
		  System.out.println(lastName+ "is not created=== PASS");
	  }
	  
	  
          //verify actual endDate 
	  String  actendDate=driver.findElement(By.id("dtlview_LastName")).getText();
	  if(actendDate.contains(endDate))
	  {
		  System.out.println(endDate+ "is created=== PASS");
	  }
	  else {
		  System.out.println(endDate+ "is not created=== PASS");
	  }
	  
	//step 5: logout
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	driver.findElement(By.linkText("Sign Out")).click();

	


	driver.quit();

	

	}

}

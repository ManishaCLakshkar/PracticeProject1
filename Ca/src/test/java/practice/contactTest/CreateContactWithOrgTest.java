package practice.contactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrgTest {
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
Workbook wb= WorkbookFactory.create(fis1);
String orgName =wb.getSheet("contact").getRow(7).getCell(2).toString()+randomint;
String contactlastName =wb.getSheet("contact").getRow(7).getCell(3).toString();
  wb.close();


WebDriver driver =null;

if(browser.contains("chrome"))
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

	//Step 2: navigate to organization Button
driver.findElement(By.linkText("Organizations")).click();


//step 3: click on "create Organisation Button"
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

//step 4: enter all the details and create new orgnisation
driver.findElement(By.name("accountname")).sendKeys(orgName);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//verify header msg expected result
String  HeaderInfo=driver.findElement(By.className("dvHeaderText")).getText();
if(HeaderInfo.contains(orgName)) {
	  System.out.println(orgName+ "is created=== PASS");
}
else {
	System.out.println(orgName+ "is not created=== fail");
}
	
// Step 5: navigate to contact module  
driver.findElement(By.linkText("Contacts")).click();

//Step 6: Click on create Contact button
driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();


//step 7: enter all the details and create new Contact.
driver.findElement(By.name("lastname")).sendKeys(contactlastName);
driver.findElement(By.xpath("//img[@name='account_name']/following-sibling::ing")).click();

//switch to child window
Set<String> set=driver.getWindowHandles();
Iterator<String> it= set.iterator();
while(it.hasNext())
{
	String windowID =it.next();
	String actUrl= driver.getCurrentUrl();
	if(actUrl.contains("modules=Accounts")){
	break;
}	
}

driver.findElement(By.name("search_text")).sendKeys(orgName);
driver.findElement(By.name("search")).click();
driver.findElement(By.xpath("//a[text()='+orgName+']")) ; //thiz is dynamic xpath

//switch to parent window
Set<String> set1=driver.getWindowHandles();
 Iterator<String> it1= set.iterator();
while(it1.hasNext())
{
	String windowID =it1.next();
	String actUrl= driver.getCurrentUrl();
	if(actUrl.contains("modules=Accounts")){
		break;
}	
}

driver.findElement(By.xpath("//input[@title = 'Save [Alt+S']")).click();

//verify the header msg into expected result

  HeaderInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(HeaderInfo.contains(orgName)) {
	  System.out.println(orgName+ "is created=== PASS");
}
else {
	System.out.println(orgName+ "is not created=== fail");
}

//verify the header orgName into expected result
String  actOrgName=driver.findElement(By.id("mouseArea_Organisation Name")).getText();
if(actOrgName.contains(orgName)) {
	  System.out.println(orgName+ "is created=== PASS");
}
else {
	System.out.println(orgName+ "is not created=== fail");
}

//step 5: logout
Actions act = new Actions(driver);
act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
driver.findElement(By.linkText("Sign Out")).click();
driver.quit();
}

}



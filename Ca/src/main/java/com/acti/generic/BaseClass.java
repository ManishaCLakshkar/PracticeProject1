package com.acti.generic;


	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Reporter;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	public class BaseClass {
		public static WebDriver driver;
		@BeforeTest
		public void openBrowser() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/login.do");
		Reporter.log("OpenBrowser",true);	
		}
		@BeforeMethod
		public void login() {
			driver.findElement(By.id("username")).sendKeys("admin");
			driver.findElement(By.name("pwd")).sendKeys("manager");
			driver.findElement(By.xpath("https://localhost/login.do")).click();
			Reporter.log("login",true);
		}
	 @AfterMethod
		public void logout() {
			driver.findElement(By.id("logoutlink")).click();
			Reporter.log("logout",true);
		}
		@AfterTest
		public void closeBrowser() {
			driver.quit();
			Reporter.log("close Browser",true);
		}
	}




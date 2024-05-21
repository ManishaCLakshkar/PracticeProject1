package practice.homepage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {
	@Test
	public void homePageTest()//Method mtd)  //Method is a class in java
	{
		System.out.println("Main start");
		
		Reporter.log("step-1");
		Reporter.log("step-2");
		Reporter.log("step-3");
		Reporter.log("step-4");
	}

	@Test
	public void verifyLogoHomePage() {

		Reporter.log("step-1");
		Reporter.log("step-2");
		Reporter.log("step-3");
		Reporter.log("step-4");

	}
}

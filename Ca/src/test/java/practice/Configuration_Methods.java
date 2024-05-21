package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Configuration_Methods {
	@BeforeSuite
	public void configBs() {
		System.out.println("ecxecute Bs");
	}
	@BeforeClass
	public void configBc() {
		System.out.println("ecxecute Bc");
	}

	@BeforeMethod
	public void configBM() {
		System.out.println("ecxecute BM");
	}

	
	@Test
	public void createContact()
	{
		System.out.println("execute create Contact");
	}
	
	@Test
	public void createContactWithSupportDate()
	{
		System.out.println("execute create Contact with date ");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("ecxecute AM");
	}
	@AfterClass
	public void configAC() {
		System.out.println("ecxecute AC");
	}
	
	@AfterSuite
	public void configAs() {
		System.out.println("ecxecute As");
	}
	

}

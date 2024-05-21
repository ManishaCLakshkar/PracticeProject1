package com.crm.generic.baseUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	@BeforeSuite
	public void configBs() {
		System.out.println("====connect to db=====,Report Config====");
	}
	@BeforeClass
	public void configBc() {
		System.out.println("Launch Browser");
	}

	@BeforeMethod
	public void configBM() {
		System.out.println("Login");
	}
	
	
	@AfterMethod
	public void configAM() {
		System.out.println("Logout");
	}
	@AfterClass
	public void configAC() {
		System.out.println("Close Browser");
	}
	
	@AfterSuite
	public void configAs() {
		System.out.println("=====close connection ====Report Backup====");
	}
}

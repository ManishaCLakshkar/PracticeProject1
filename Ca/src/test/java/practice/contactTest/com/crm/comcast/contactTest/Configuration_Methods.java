package com.crm.comcast.contactTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseUtility.BaseClass;

public class Configuration_Methods extends BaseClass {
	

	
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
	
	

}

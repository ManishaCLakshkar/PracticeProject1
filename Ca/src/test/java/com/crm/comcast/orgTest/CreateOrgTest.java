package com.crm.comcast.orgTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseUtility.BaseClass;

public class CreateOrgTest extends BaseClass{

	
	@Test
	public void createOrgTest()
	{
		System.out.println("execute create Contact");
		System.out.println(" test 1");
	}
	
	@Test
	public void createOrgWithIndustry()
	{
		System.out.println("execute createOrgWithIndustry");
	}
	
	

}

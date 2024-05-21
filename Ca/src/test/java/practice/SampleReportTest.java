package practice;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	@Test
	public void createContactTest() {
		//Spark report config
		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add environment information and create test
		ExtentReports report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("Browser", "chrome-100");
		ExtentTest test=report.createTest("createContactTest");
		
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HFDC"))
		{
			test.log(Status.PASS, " contact is created ");
		}
		else
		{
			test.log(Status.FAIL, " contact is not  created ");
		}
		report.flush();
		
	}

}

package com.acti.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.acti.generic.BaseClass;

public class ListenerImplementation {
	public class Listener_Implementation extends BaseClass implements ITestListener{
		@Override
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestStart(result);
		}
		//test success
		@Override
		public void onTestSuccess(ITestResult result) {
			String res =result.getName();
			Reporter.log(res+" has got passed",true);
		}
		//Test failure
		@Override
		public void onTestFailure(ITestResult result) {
			String res= result.getName();
		String timeStamp=LocalDateTime.now().toString().replace(':', '-');
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshot/"+res+timeStamp+".png");
			Reporter.log(res+" has got failed",true);
			try {
				FileUtils.copyFile(src, dest);
			}
			catch(IOException e)
			{
				
			}
			
		}

		
		//Test Skipped
		@Override
		public void onTestSkipped(ITestResult result) { 
			String res= result.getName();
			Reporter.log(res+"has got skipped",true);
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedWithTimeout(result);
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			ITestListener.super.onStart(context);
		}

		@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			ITestListener.super.onFinish(context);
		}

	}

}

package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;


public class SampleTakeScreenShot {
	
	@Test
	public void amazonTest() throws IOException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in");
		//create object of of webdriver 
		EventFiringWebDriver edriver= new EventFiringWebDriver(driver);
		
		//step 2: use getScreeenshotAs method to get file type of screenshot
		File srcFile= edriver.getScreenshotAs(OutputType.FILE);
		
		//step 3: Store screenshot on local driver 
		FileUtils.copyFile(srcFile, new File("./screenshot/test.png"));
		
		
		
	}

}

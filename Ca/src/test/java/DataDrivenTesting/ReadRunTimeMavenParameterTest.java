package DataDrivenTesting;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ReadRunTimeMavenParameterTest {
	@Test
	public void runTimeParameterTest() {
		String URL= System.getProperty("url");
		String BROWSER= System.getProperty("browser");
		String USERNAME= System.getProperty("username");
		String PASSWORD= System.getProperty("password");
		
		System.out.println("url"+URL);
		System.out.println("browser"+BROWSER);
		System.out.println("username"+USERNAME);
		System.out.println("password"+PASSWORD);
	}

}

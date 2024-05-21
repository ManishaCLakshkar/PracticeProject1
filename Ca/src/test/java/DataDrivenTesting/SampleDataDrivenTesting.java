package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./data/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
	String	url=p.getProperty("url");
	String	un=p.getProperty("username");
	String pwd = p.getProperty("password");
	System.out.println(url);
	System.out.println(un);
	System.out.println(pwd );
	}

}

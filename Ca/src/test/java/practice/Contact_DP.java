package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Contact_DP {

	@Test(dataProvider="getData")
	public void createContactTest(String firstName, String LastName, long phoneNumber)
	{
		System.out.println("Firstname : "+firstName+" LastName : "+LastName +"phoneNumber :"+phoneNumber);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr= new Object[3][3];
		objArr[0][0]="Deepak";
		objArr[0][1]="hr";
		objArr[0][2]=1234567890l;//
		
		objArr[1][0]="sam";
		objArr[1][1]="hd";
		objArr[1][2]= 2345678908l;
		
		objArr[2][0]="john";
		objArr[2][1]="smith";
		objArr[2][2]= 6754321345l;
		return objArr;
	}
}

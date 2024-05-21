package practice;

import org.testng.annotations.Test;

public class ContactTest {
	@Test(priority =1)
	public void createCustomer()
	{
		System.out.println("execute create Contact");
	}

	@Test(priority =2)
	public void modifycontact()
	{
		System.out.println("execute modify contact");
	}
	
	@Test(priority =3)
	public void deleteContact()
	{
		System.out.println("execute delete contact");
	}
}

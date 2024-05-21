package practice;

import org.testng.annotations.Test;

public class DependsOnMethod {
	
	@Test
	public void createOrderTest() {
		System.out.println("Execute CreateOrder");
		String str=null;
		System.out.println(str.equals("123"));
	}
	
	@Test(dependsOnMethods="createOrderTest")
	public void  billingOrderTest() {
		System.out.println("ExecuteBilling Order ===123");
	}

}

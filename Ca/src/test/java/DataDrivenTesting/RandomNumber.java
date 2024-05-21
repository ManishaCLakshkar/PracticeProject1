package DataDrivenTesting;

import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
		Random r = new Random();
	int randomint=	r.nextInt(1000);
	System.out.println(randomint);
	}

}

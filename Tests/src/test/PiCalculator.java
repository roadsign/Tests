package test;


import java.util.Random;

public class PiCalculator {

	public static void main(String[] args) {
		Random random = new Random();
		double x, y;
		double r = 1.0;
		int n = 0;
		
		for (int i=0; i<100000; i++)
		{
			x = random.nextDouble();
			y = random.nextDouble();
			
			if (x*x + y*y <= r)
				n++;			
		}
		
		double pi = (double) 4*n/100000;
		System.out.println(pi);
	}
	
	
	

}

package test;

public class Examples{
	
	public static void main (String[] args) {
		
		
		long startTime = System.currentTimeMillis();
		
		if (ehPrimo(17))
			System.out.println("Sim");
		else
			System.out.println("Não");
		
		long endTime = System.currentTimeMillis() - startTime;
		System.out.println(endTime);

	}
	

  private static boolean ehPrimo (int n){
    /*switch (n){
      case 0: return false;
      case 1: return false;
      case 2: return true;
      case 3: return true;
      case 5: return true;
      case 7: return true;
    }*/

    if (n % 2 == 0)
      return false;
    if (n % 3 == 0)
      return false;
    if (n % 5 == 0)
      return false;
    if (n % 7 == 0)
      return false;

    int range = (int) Math.sqrt(n);
    for (int i = 3; i <= range; i+=2)
      if (n % i == 0)
        return false;

    return true;
  }
}
import java.util.ArrayList;
import java.util.Collections;


/*
  	public static boolean isTriangle(int a, int b, int c){
	
	ArrayList<Integer> sides = new ArrayList<Integer>();
	Collections.addAll(sides, a,b,c);
	
	int maxVal = a;
	int sum = a;
	
	for(int i = 1; i < 3; i++)
	{
		int num = sides.get(i);
		sum = sum + num;
		if(num > maxVal)
		{
			maxVal = num;
		}
	}
	return ((sum - maxVal) > maxVal) ? true : false;
	
	
  }
 */
class TriangleTester{
	
  public static boolean isTriangle(int a, int b, int c) {
	
	int a1 = Math.max(a, b);
	int max = Math.max(a1, c);
	return ( ( (a+b+c) - max) > max ) ? true : false;
	
  }
  
  static public void main(String args[])
  {
	  doTest(true, 1, 2, 2);
      doTest(true, 4, 2, 3);
      doTest(true, 2, 2, 2);
      doTest(false, 1, 2, 3);
      doTest(false, -5, 1, 3);
      doTest(false, 0, 2, 3);
      doTest(false, 1, 2, 9);
	  doTest(true,  1,2,2);
      doTest(false, 7,2,2);
      doTest(true, 2,2,2);
  }
  
  private static void doTest(boolean expected, int a, int b, int c) {
      boolean actual = TriangleTester.isTriangle(a, b, c);
      
      if(actual == expected)
      {
    	  System.out.println("OK");
      }
      else
      {
    	  System.out.printf("Not OK with: %d %d %d \n", a,b,c);
      }
  }
}
// Make sure your class is public
 public class Kata {
    public static double findUniq(double arr[]) {
    	
      for(int i=2; i<arr.length;i++)
      {
    	  if(arr[i] != arr[i-2] || arr[i] != arr[i-1])
    	  {
    		  if(arr[i] == arr[i-2]){
    			  return arr[i-1];
    		  }
    		  else if(arr[i] == arr[i-1]){
    			  return arr[i-2];
    		  }
    		  else{
    			  return arr[i];
    		  }
    	  }
      }
      return arr[0];
    }
    
    public static void main(String args[])
    {
    	sampleTestCases();
    	return;
    }
    
    static public void assertEquals(double exp, double ans, double prec)
    {
      if( exp == ans)
   	  {
   		  System.out.println("OK");
   	  }
   	  else
   	  {
   		  System.out.println("Not OK with: " + exp + " | " + ans);
   	  }
    }
    
    static public void sampleTestCases() {
    	
    	double precision = 0.0000000000001;
    	
        assertEquals(1.0, Kata.findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(0.0, Kata.findUniq(new double[]{0, 1, 1, 1, 1}), precision);
        assertEquals(2.0, Kata.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }
}
public class Kata {
	/*
	 public static int findEvenIndex(int[] arr) {
    int totalSum = 0;
    for (int num : arr) {
        totalSum += num;
    }

    int leftSum = 0;

    for (int i = 0; i < arr.length; i++) {
        int rightSum = totalSum - leftSum - arr[i];
        if (leftSum == rightSum) {
            return i;
        }
        leftSum += arr[i];
    }

    return -1;
}
	 */

	public static int findEvenIndex(int[] arr) {
	    int sum = 0;
	    for (int num : arr) {
	    	 sum += num;
	    }

	    int left = 0;
	    int right = 0;
	    
	    for(int i=0;i<arr.length;i++)
	    {	    	
	    	
	    	right = sum - left - arr[i];
	    	
    		if(left == right) {
    			return i;
    		}
    		
    		left = left + arr[i];
	    	
	    }
	    return -1;
	}
  
  public static void assertEquals(int expected, int[] arr)
  {
	  if( expected == findEvenIndex(arr))
	  {
		  System.out.println("OK");
	  }
	  else
	  {
		  System.out.println("Not OK");
	  }
  }
  
  static public void main(String args[])
  {
	  assertEquals(3,new int[] {1,2,3,4,3,2,1});
      assertEquals(1,new int[] {1,100,50,-51,1,1});
      assertEquals(-1,new int[] {1,2,3,4,5,6});
      assertEquals(3,new int[] {20,10,30,10,10,15,35});
      assertEquals(-1,new int[] {-8505, -5130, 1926, -9026});
      assertEquals(1,new int[] {2824, 1774, -1490, -9084, -9696, 23094});
      assertEquals(6,new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4});
  }
  
}
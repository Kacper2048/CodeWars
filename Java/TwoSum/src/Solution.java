import java.util.ArrayList;

public class Solution {
	
	public static int[] twoSum(int[] numbers, int target) {
		
	    for (int i = 0; i < numbers.length; i++) {
	        for (int j = i + 1; j < numbers.length; j++) {
	            if (numbers[i] + numbers[j] == target) {
	                return new int[]{i, j};
	            }
	        }
	    }
	    return null;  // Return null if no such pair exists
	}
    
    
    public static void arguments(int[] arr, int val, int[] answer)
    {
    	ArrayList<Integer> result = new ArrayList<>();
    	ArrayList<Integer> ans = new ArrayList<>();
    	for (int num :  twoSum(arr, val)) {
    	    result.add(num); 
    	}
    	
    	for (int num :  answer) {
    	    ans.add(num); 
    	}
    	
    	if( result.equals(ans))
    	{
    		System.out.println("OK");
    	}
    	else
    	{
    		System.out.print("Not OK: result:");
    		
    		for (int num :  result) {
        	    System.out.print( num + ", "); 
        	}
    		System.out.print("  ans: "); 
        	for (int num :  ans) {
        		System.out.print( num + ", ");  
        	}
        	System.out.println(); 
    	}
    }
    
    static public void main(String args[])
    {
    	arguments(new int[]{1,2,3},          4,     new int[]{0,2});
        arguments(new int[]{1234,5678,9012}, 14690, new int[]{1,2});
        arguments(new int[]{2,2,3},          4,     new int[]{0,1});
        arguments(new int[]{2,3,1},          4,     new int[]{1,2});
    }
}
import java.util.ArrayList;

class Solution {
	/*
	 public static String rangeExtraction(int[] arr) {
			
		if(arr.length == 0)
		{
			return "-1";
		}
		
		ArrayList<Integer> tempVal = new ArrayList<Integer>();
		ArrayList<String> ans = new ArrayList<String>();
		
		int atLeast2 = 0;
		
		for(int i=1; i< arr.length; i++)
		{
			if(atLeast2 == 0)
			{
				tempVal.add(arr[i-1]);
			}
	
			if(arr[i] - arr[i-1] == 1 && i < arr.length-1)
			{
				System.out.println(tempVal);
				atLeast2++;
				tempVal.add(arr[i]);
			}
			else if(atLeast2 >= 2)
			{
				System.out.println(tempVal);
				ans.add(tempVal.get(0) + "-"+ tempVal.get(tempVal.size()-1));
				
				atLeast2 = 0;
				tempVal.clear();
			}
			else
			{
				System.out.println(tempVal);
				for(int el : tempVal)
				{
					ans.add( String.valueOf(el));
				}
				atLeast2 = 0;
				tempVal.clear();
			}
		}
		
		
		if(atLeast2 == 0)
		{
			tempVal.add(arr[arr.length-1]);
		}
		
		if(atLeast2 >= 2)
		{
			ans.add(tempVal.get(0) + "-"+ tempVal.get(tempVal.size()-1));
			atLeast2 = 0;
			tempVal.clear();
		}
		else
		{
			for(int el : tempVal)
			{
				ans.add( String.valueOf(el));
			}
			atLeast2 = 0;
			tempVal.clear();
		}
		
		System.out.println(ans.toString());
		return  ans.toString().replace(" ", "").replace("[","").replace("]", "");
    }
	*/
	
	/*

	public static String rangeExtraction(int[] arr) {
		ArrayList<Integer> tempVal = new ArrayList<Integer>();
		ArrayList<String> ans = new ArrayList<String>();
		
		int atLeast2 = 0;
		
		for(int i=0; i< arr.length; i++)
		{
			if(atLeast2 == 0)
			{
				tempVal.add(arr[i]);
			}
	
			if( (i < arr.length-1) && (arr[i+1] - arr[i] == 1))
			{
				atLeast2++;
				tempVal.add(arr[i+1]);
			}
			else if(atLeast2 >= 2)
			{
				ans.add(tempVal.get(0) + "-"+ tempVal.get(tempVal.size()-1));
				atLeast2 = 0;
				tempVal.clear();
			}
			else
			{
				for(int el : tempVal)
				{
					ans.add( String.valueOf(el));
				}
				atLeast2 = 0;
				tempVal.clear();
			}
		}
		return  ans.toString().replace(" ", "").replace("[","").replace("]", "");
    }
		*/
	
	public static String rangeExtraction(int[] arr) {
		ArrayList<Integer> tempVal = new ArrayList<Integer>();
		ArrayList<String> ans = new ArrayList<String>();
		int index = 0;
		
		for(int i=0; i< arr.length; i++)
		{
			tempVal.clear();
			tempVal.add(arr[i]);
			index = i;
			
			while((index < arr.length-1) && (arr[index+1] - arr[index] == 1)) {
    				tempVal.add(arr[index+1]);
    				index++;
			}
			i = index;
			if(tempVal.size() >= 3) {
				ans.add(tempVal.get(0) + "-"+ tempVal.get(tempVal.size()-1));
			}
			else {
				for(int el : tempVal) {
					ans.add( String.valueOf(el));
				}
			}
		}
		return  ans.toString().replace(" ", "").replace("[","").replace("]", "");
	}
	

	
	static public void main(String args[])
	{
		test_BasicTests();
	}
	
	static public void assertEquals(String exp, String ans)
	{
		if(exp.equals(ans))
		{
			System.out.println("OK");
		}
		else
		{
			System.out.println("Not OK with: " + ans + " | " + exp);
		}
		
	}
	
	static public void test_BasicTests() {
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", Solution.rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20}));
        assertEquals("-3--1,2,10,15,16,18-20", Solution.rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));
        assertEquals("-25,-23,-20,-18,-15--13,-11--9,-6", Solution.rangeExtraction(new int[] {-25, -23, -20, -18, -15, -14, -13, -11, -10, -9, -6}));
    }
}
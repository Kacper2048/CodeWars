import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class EnoughIsEnough {
	/*
	 * public static int[] deleteNth(int[] elements, int maxOccurrences) {
		
		ArrayList<Integer> elementsAL = new ArrayList<Integer>();
		
		for(int el : elements)
		{
			if( Collections.frequency(elementsAL, el) < maxOccurrences)
			{
				elementsAL.add(el);
			}
		}
		
		int[] result = new int[elementsAL.size()];
		
		for (int i = 0; i < elementsAL.size(); i++) {
		    result[i] = elementsAL.get(i); // Auto-unboxing Integer to int
		}
		return result;
	}
	 */
	public static int[] deleteNth(int[] elements, int maxOccurrences) {
	    ArrayList<Integer> resultList = new ArrayList<>();
	    HashMap<Integer, Integer> counts = new HashMap<>();

	    for (int el : elements) {
	        counts.put(el, counts.getOrDefault(el, 0) + 1);

	        if (counts.get(el) <= maxOccurrences) {
	            resultList.add(el);
	        } else {
	            counts.put(el, counts.get(el) - 1);
	        }
	    }


	    int[] result = new int[resultList.size()];
	    for (int i = 0; i < resultList.size(); i++) {
	        result[i] = resultList.get(i);
	    }
	    return result;
	}
	
	
	public static void assertArrayEquals(int[] exp, int[] ans)
	{
		ArrayList<Long> expAL = new ArrayList<Long>();
		ArrayList<Long> ansAL = new ArrayList<Long>();
		for( long el : exp)
		{
			expAL.add(el);
		}
		
		for( long el : ans)
		{
			ansAL.add(el);
		}
		
		if(ansAL.equals(expAL))
		{
			System.out.println("OK");
		}else
		{
			System.out.print("Not OK: ");
			for( long el : exp)
			{
				System.out.print(el + ", ");
			}
			System.out.print(" | ");
			for( long el : ans)
			{
				System.out.print(el + ", ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[])
	{
		assertArrayEquals(
				new int[] { 20, 37, 21 },
				EnoughIsEnough.deleteNth( new int[] { 20, 37, 20, 21 }, 1 )
		);
		assertArrayEquals(
				new int[] { 1, 1, 3, 3, 7, 2, 2, 2 },
				EnoughIsEnough.deleteNth( new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3 )
				
		);
		assertArrayEquals(
				new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 },
				EnoughIsEnough.deleteNth( new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3 )
		);
		assertArrayEquals(
				new int[] { 1, 1, 1, 1, 1 },
				EnoughIsEnough.deleteNth( new int[] { 1, 1, 1, 1, 1 }, 5 )
		);
		assertArrayEquals(
				new int[] { },
				EnoughIsEnough.deleteNth( new int[] { }, 5 )
		);
	}
}

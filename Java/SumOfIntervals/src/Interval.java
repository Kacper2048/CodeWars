import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Interval {

	/*
    public static int sumIntervals(int[][] intervals) {
        
    	ArrayList<Integer> S = new ArrayList<>();
    	ArrayList<Integer> E = new ArrayList<>();
    	
    	if( intervals.length == 0)
    	{
    		return 0;
    	}
    	
    	int dys = 0;
	    int minIndex = 0;
	    int minVal = intervals[0][0];
	    int maxVal = intervals[0][1];
    	    
    	for(int y = 0; y < intervals.length; y++)
        {
        	S.add(intervals[y][0]);
        	E.add(intervals[y][1]);
        }
    	
    	for(int y = 1; y < intervals.length; y++)
        {
        	if(S.get(y) < minVal)
        	{
        		minIndex = y;
        		minVal = S.get(y);
        	}
        }	
    	
    for(int y = 0; y< intervals.length;y++)
    {
    	if(E.get(y) > maxVal)
    	{
    		maxVal = E.get(y);
    	}
    }
    
    int posS;
    int posE = minVal;
    
    while(posE < maxVal)
    {
    	
    	posS = posE > S.get(minIndex) ? posE : S.get(minIndex);
    	posE = E.get(minIndex);
    	
    	for(int i = 0; i < S.size(); i++) //check intervals
    	{
    		if( S.get(i) < posE && posE < E.get(i) )
    		{
    			posE = E.get(i);
    		}
    	}
    	
    	dys = dys + ( posE - posS ); 

    	for(int i = 0; i < S.size(); i++)
    	{
    		if( E.get(i) <= posE)
    		{
    			S.remove(i);
    		    E.remove(i);
    		    i--;
    		}
    	}
    	
    	for(int y = 0; y < S.size(); y++) //look for next min but bigger than our current posE
        {
    		if (y == 0) {
			    minVal = S.get(0);
			    minIndex = 0;
			}
    		
    		else if (S.get(y) <= minVal) {
			    minIndex = y;
			    minVal = S.get(y);
			}
        }
    }
        return dys;
    }
    */
	


	
	    public static int sumIntervals(int[][] intervals) {
	        if (intervals == null || intervals.length < 1) {
	            return 0;
	        }
	        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
	        int result = 0;
	        int currentIntervalEnd = intervals[0][0];

	        for (int[] interval : intervals) {
	            int intervalStart = interval[0];
	            int intervalEnd = interval[1];
	            if (intervalEnd > currentIntervalEnd) {
	                result += intervalEnd - Math.max(intervalStart, currentIntervalEnd);
	                currentIntervalEnd = intervalEnd;
	            }
	        }
	        return result;
	}
    
    static public void main( String args[])
    {
    	shouldHandleEmptyIntervals();
    	shouldAddDisjoinedIntervals();
    	shouldHandleLargeIntervals();
    	shouldAddAdjacentIntervals();
    	
    	shouldAddOverlappingIntervals();
        shouldHandleMixedIntervals();
    }
    
    static public void assertEquals(int exp, int ans)
    {
    	if(exp == ans)
    	{
    		System.out.println("OK");
    	}
    	else
    	{
    		System.out.println("not OK with: " + exp + " | " + ans);
    	}
    }
    
   	public static void shouldHandleEmptyIntervals() {
   		assertEquals(0, sumIntervals(new int[][]{}));
   		assertEquals(0, sumIntervals(new int[][]{{4, 4}, {6, 6}, {8, 8}}));
   	}
	
   	public static void shouldAddDisjoinedIntervals() {
   		assertEquals(9, sumIntervals(new int[][]{{1, 2}, {6, 10}, {11, 15}}));
   		assertEquals(11, sumIntervals(new int[][]{{4, 8}, {9, 10}, {15, 21}}));
   		assertEquals(7, sumIntervals(new int[][]{{-1, 4}, {-5, -3}}));
   		assertEquals(78, sumIntervals(new int[][]{{-245, -218}, {-194, -179}, {-155, -119}}));
   	}
     
    
   	public static void shouldHandleLargeIntervals() {
   		assertEquals(2_000_000_000, sumIntervals(new int[][]{{-1_000_000_000, 1_000_000_000}}));
   		assertEquals(100_000_030, sumIntervals(new int[][]{{0, 20}, {-100_000_000, 10}, {30, 40}}));
   	}

   	
   	public static void shouldAddAdjacentIntervals() {
   		assertEquals(54, sumIntervals(new int[][]{{1, 2}, {2, 6}, {6, 55}}));
   		assertEquals(23, sumIntervals(new int[][]{{-2, -1}, {-1, 0}, {0, 21}}));
   	}

   
   	public static void shouldAddOverlappingIntervals() {
   		assertEquals(7, sumIntervals(new int[][]{{1, 4}, {7, 10}, {3, 5}}));
   		assertEquals(6, sumIntervals(new int[][]{{5, 8}, {3, 6}, {1, 2}}));
   		assertEquals(19, sumIntervals(new int[][]{{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}}));
   	}

   
   	public static void shouldHandleMixedIntervals() {
   		assertEquals(13, sumIntervals(new int[][]{{2, 5}, {-1, 2}, {-40, -35}, {6, 8}}));
   		assertEquals(1234, sumIntervals(new int[][]{{-7, 8}, {-2, 10}, {5, 15}, {2000, 3150}, {-5400, -5338}}));
   		assertEquals(158, sumIntervals(new int[][]{{-101, 24}, {-35, 27}, {27, 53}, {-105, 20}, {-36, 26},}));
   		
   		assertEquals(
   				178, 
   			    sumIntervals(new int[][]{
   			        {400, 416}, 
   			        {307, 314}, 
   			        {-226, -218}, 
   			        {-107, -97}, 
   			        {377, 382},
   			        {142, 160}, 
   			        {90, 110}, 
   			        {425, 437}, 
   			        {338, 353}, 
   			        {-370, -365},
   			        {231, 251}, 
   			        {266, 277}, 
   			        {-317, -309}, 
   			        {-464, -461}, 
   			        {60, 80}
   			    })
   			);
   		
   		assertEquals(
   			    106,
   			    sumIntervals(new int[][]{
   			        {-441, -439}, 
   			        {-297, -282}, 
   			        {-403, -400}, 
   			        {-418, -400}, 
   			        {-421, -410}, 
   			        {-79, -75}, 
   			        {448, 455}, 
   			        {-233, -218}, 
   			        {68, 79}, 
   			        {-329, -323}, 
   			        {210, 211}, 
   			        {306, 324}, 
   			        {-179, -173}, 
   			        {-405, -402}
   			    })
   			);
   	}
}

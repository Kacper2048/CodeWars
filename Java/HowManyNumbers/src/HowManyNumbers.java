import java.util.*;

class HowManyNumbers {

    public static List<Long> findAll(final int sumDigits, final int numDigits) {
    	List<Long> ans = new ArrayList<Long>(0);
    	
    	List<Long> result = new ArrayList<Long>(3);
    	
    	generate(new int[numDigits], 0, numDigits,1,sumDigits,ans );
    	
    	if(ans.size() > 0)
    	{
    		result.add((long)ans.size());
        	result.add(Collections.min(ans));
        	result.add(Collections.max(ans));
        	
    	}
    	
        return result;
    }
    
    public static void generate(int[] current, int depth, int maxDepth, int limit, int sumDigits, List<Long> ans) {
    	
    	
    	if (depth == maxDepth) {
    		
        	int sum = 0;
        	for(int i=0; i < maxDepth; i++)
        	{
       
        		sum += current[i];
        	}
        	
        	if(sum == sumDigits)
        	{
        		long temp = 0 ;
        		for(int i=(maxDepth-1); i >= 0; i--)
            	{
        			temp += (current[(maxDepth-1)-i] * Math.pow(10, i));
            	}
        		ans.add(temp);
        	}
            return;
        }
    	
        for (int i = limit; i <= 9; i++) {
        	
            current[depth] = i;
            generate(current, depth + 1, maxDepth, i, sumDigits ,ans);
        }
    }
    
    public static void main(String args[])
    {
    	exampleTests();
    }
    
    public static void assertEquals(List<Long> exp, List<Long> ans)
    {
    	if( ans.equals(exp) )
    	{
    		System.out.println("OK");
    	}
    	else
    	{
    		System.out.println("not OK with: " + exp + "   " + ans);
    	}
    }
    
    static public void exampleTests() {
        assertEquals(Arrays.asList(8L, 118L, 334L),         HowManyNumbers.findAll(10, 3));
        assertEquals(Arrays.asList(1L, 999L, 999L),         HowManyNumbers.findAll(27, 3));
        assertEquals(new ArrayList<Long>(),                 HowManyNumbers.findAll(84, 4));
        assertEquals(Arrays.asList(123L, 116999L, 566666L), HowManyNumbers.findAll(35, 6));
    }
}
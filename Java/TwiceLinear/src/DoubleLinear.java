import java.util.*;

class DoubleLinear {
    
    public static int dblLinear (int n) {
    	PriorityQueue<Integer> u = new PriorityQueue<Integer>();
    	u.add(1);
    	
    	int indexX = 0;
    	int y;
    	int z;
    	int x;
    	while(indexX < n)
    	{
    		x = u.poll();
    		
    		y = 2 * x + 1;
    		z = 3 * x + 1;
    		
    		if(!u.contains(y))
    		{
    			u.add(y);
    		}
    		
    		if(!u.contains(z))
    		{
    			u.add(z);
    		}
        	indexX++;
    	}
    	return  u.poll();
    }
    
    public static void testing(int ans, int exp)
    {
    	if( ans == exp)
    	{
    		System.out.println("OK");
    	}
    	else
    	{
    		System.out.println("Not OK: exp: " +exp + " | ans: " + ans );
    	}
    }
    
    static public void main(String args[])
    {
    	test();
    }
    
    public static void test() {
        testing(DoubleLinear.dblLinear(10), 22);
        testing(DoubleLinear.dblLinear(20), 57);
        testing(DoubleLinear.dblLinear(30), 91);
        testing(DoubleLinear.dblLinear(50), 175);
             
    }
}
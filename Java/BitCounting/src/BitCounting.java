public class BitCounting {

	/*public static int countBits(int n)
	{
		int i = 0;
		while(n >= 1)
		{
			i += ((n % 2) == 1) ? 1 : 0;
			n = (int)(n/2);
		}
		return i;
	}
	*/
	public static int countBits(int n)
	{
		
	    return Integer.bitCount(n);
	}
	
	static public void assertEquals(int exp,int ans)
	{
		if(exp == ans)
		{
			System.out.println("OK");
		}
		else
		{
			System.out.println("Not OK with: " + exp + " != " + ans);
		}
	}
	
	static public void main(String args[])
	{
		testGame();
	}
	static public void testGame() {
	    assertEquals(5, BitCounting.countBits(1234)); 
	    assertEquals(1, BitCounting.countBits(4)); 
	    assertEquals(3, BitCounting.countBits(7)); 
	    assertEquals(2, BitCounting.countBits(9)); 
	    assertEquals(2, BitCounting.countBits(10)); 
	  }
}
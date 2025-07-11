import java.util.ArrayList;

public class ProdFib { // must be public for codewars	
	
	
	public static long[] productFib(long prod) {
	
		ArrayList<Long> Fib = new ArrayList<Long>();
		Fib.add(0L);
		Fib.add(1L);
		int index = 1;
		
		while( true ) {
			long fib1 = Fib.get(index-1);
			long fib2 = Fib.get(index);
			Fib.add(fib1+fib2);
			
			if(fib1*fib2 >= prod ) {
				return new long[]{fib1, fib2, (fib1*fib2 == prod)? 1: 0};
			}
			
			index++;
		}
   }
	
	public static void assertArrayEquals(long[] exp, long[] ans)
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
			System.out.println("Not OK");
			for( long el : exp)
			{
				System.out.println(el + ", ");
			}
			System.out.print(" | ");
			for( long el : ans)
			{
				System.out.println(el + ", ");
			}
			System.out.println();
		}
		
	}
	
	static public void main(String args[])
	{
		
			long[] r = new long[] {55, 89, 1};
			assertArrayEquals(r, ProdFib.productFib(4895));
		
	
			long[] q = new long[] {89, 144, 0};
			assertArrayEquals(q, ProdFib.productFib(5895));
		
	}
}
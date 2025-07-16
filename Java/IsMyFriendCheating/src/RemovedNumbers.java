import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RemovedNumbers {
	/*
	public static List<long[]> removNb(long n) {
		List<long[]> ans = new ArrayList<>();
		long sum = 0;
		
		sum = ((1+n)/2) * (n+1);
		
		System.out.println(sum);
		
		for(int i=1; i<=n; i++)
		{
			for(int q=1; q<=n; q++)
			{
				if( (sum - i - q) == (i * q))
				{
					ans.add(new long [] {i,q} );
				}
			}
		}
		
		ans.stream().map( (e) -> {System.out.println(e[0] + " | " + e[1]); return e;} ).collect(Collectors.toList());
		return ans;
	}
	 */
	public static List<long[]> removNb(long n) {
		List<long[]> ans = new ArrayList<>();
		long sum = n * (1+n)/2;
		
		long a = 0;
		for(int b=1; b<=n; b++)
		{
			a = ((sum - b) / (b+1));
			if( a <= n && sum == (a * b + a + b))
			{
				ans.add(new long [] {b,a} );
			}
		}
		return ans;
	}
	
	
	static public void main(String args[])
	{
		test12();
		test14();
	}
	
	static public void test12() {
		List<long[]> res = new ArrayList<long[]>();
		res.add(new long[] {15, 21});
		res.add(new long[] {21, 15});
		List<long[]> a = RemovedNumbers.removNb(26);
		List<long[]> b = RemovedNumbers.removNb(100);
		//List<long[]> c = RemovedNumbers.removNb(500004000008L);
		//assertArrayEquals(res.get(0), a.get(0));
		//assertArrayEquals(res.get(1), a.get(1));
	}
	
	static public void test14() {
		List<long[]> res = new ArrayList<long[]>();
		List<long[]> a = RemovedNumbers.removNb(100);
		
	}
}
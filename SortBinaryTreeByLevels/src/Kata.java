import java.util.*;

class Node {
	public Node left;
	public Node right;
	public int value;
	  
	public Node(Node l, Node r, int v) {
		left = l;
		right = r;
		value = v;
	}
}


/*



  public static List<Integer> treeByLevels(Node node)
	{
    if(node == null)
		{
			return new ArrayList<Integer>();
		}
    
		int lvl = 0;
		List< ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
		List< Integer > ans = new ArrayList<Integer>();
		
		if(result.size() == lvl)
		{
			result.add( new ArrayList<Integer>() );
		}
		result.get(lvl).add(node.value);

		if(node.left != null)
		{
			goChild(node.left, lvl+1, result);
		}
		
		if(node.right != null)
		{
			goChild(node.right, lvl+1, result);
		}
		
		
		for( int lvlAns = 0; lvlAns < result.size(); lvlAns++)
		{
			System.out.print("lvl: " + lvlAns + " - ");
			for( int el = 0; el < result.get(lvlAns).size(); el++)
			{
				int x = result.get(lvlAns).get(el);
				System.out.print(x + ", ");
				ans.add(x);
			}
			System.out.println();
		}
		return ans;
	}
  public static void goChild(Node child, int lvl, List< ArrayList<Integer>> resultPTR)
	{
		if(resultPTR.size() == lvl)
		{
			resultPTR.add( new ArrayList<Integer>() );
		}
		resultPTR.get(lvl).add(child.value);

		if(child.left != null)
		{
			goChild(child.left, lvl+1, resultPTR);
		}
		
		if(child.right != null)
		{
			goChild(child.right, lvl+1, resultPTR);
		}
	}
	
	
	
	//----------------------------------------------------------
	public static List<Integer> treeByLevels(Node node)
	{
		if(node == null)
		{
			return new ArrayList<Integer>();
		}
		
		int lvl = 0;
		List< ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
		List< Integer > ans = new ArrayList<Integer>();
		
		result.add( new ArrayList<Integer>() );
		result.get(lvl).add(node.value);

		goChild(node.left, lvl+1, result);
		goChild(node.right, lvl+1, result);
		
		for( int lvlAns = 0; lvlAns < result.size();)
		{
			for( int el = 0; el < result.get(lvlAns).size(); el++)
			{
				int x = result.get(lvlAns).get(el);
				ans.add(x);
			}
			result.remove(lvlAns);
		}
		return ans;
	}
		  
	public static void goChild(Node child, int lvl, List< ArrayList<Integer>> resultPTR)
	{
		if(child == null)
		{
			return;
		}
		
		if(resultPTR.size() == lvl)
		{
			resultPTR.add( new ArrayList<Integer>() );
		}
		
		resultPTR.get(lvl).add(child.value);

		goChild(child.left, lvl+1, resultPTR);
		goChild(child.right, lvl+1, resultPTR);
	}

*/

class Kata {
	
	public static List<Integer> treeByLevels(Node node) //DFS
	{
		if(node == null)
		{
			return new ArrayList<Integer>();
		}
		
		int lvl = 0;
		List< ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
		List< Integer > ans = new ArrayList<Integer>();
		
		result.add( new ArrayList<Integer>() );
		result.get(lvl).add(node.value);

		goChild(node.left, lvl+1, result);
		goChild(node.right, lvl+1, result);
		
		for( int lvlAns = 0; lvlAns < result.size();)
		{
			for( int el = 0; el < result.get(lvlAns).size(); el++)
			{
				int x = result.get(lvlAns).get(el);
				ans.add(x);
			}
			result.remove(lvlAns);
		}
		return ans;
	}
		  
	public static void goChild(Node child, int lvl, List< ArrayList<Integer>> resultPTR)
	{
		if(child == null)
		{
			return;
		}
		
		if(resultPTR.size() == lvl)
		{
			resultPTR.add( new ArrayList<Integer>() );
		}
		
		resultPTR.get(lvl).add(child.value);

		goChild(child.left, lvl+1, resultPTR);
		goChild(child.right, lvl+1, resultPTR);
	}
	
	static public void main(String args[])
	{
		basicTest();
	}
	
	public static void nullTest() {
	  assertEquals(Arrays.asList(), Kata.treeByLevels(null));
	}
	    
	public static void assertEquals(List<Integer> a, List<Integer> b)
	{
		
	}
	
	public static void basicTest() {
	  assertEquals(Arrays.asList(1,2,3,4,5,6), Kata.treeByLevels(
			  new Node(new Node(null, 
						  new Node(null, null, 4), 2), 
							  new Node(new Node(null, null, 5), 
									   new Node(null, null, 6),
									  3),
			  1)));
	}
}
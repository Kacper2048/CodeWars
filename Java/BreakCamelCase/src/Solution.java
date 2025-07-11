public class Solution {
	public static void main(String args[])
	{
		assertEquals( "Incorrect", "camel Casing", Solution.camelCase("camelCasing"));
	    assertEquals( "Incorrect", "camel Casing Test", Solution.camelCase("camelCasingTest"));
	    assertEquals( "Incorrect", "camelcasingtest", Solution.camelCase("camelcasingtest"));
	}
	
	static public void assertEquals(String str, String exp, String result)
	{
		if(exp.equals(result))
		{
			System.out.println("OK");
		}
		else
		{
			System.out.println("Not OK: " + exp + " || " + result);
		}
	}
	
	public static String camelCase(String input) {
		
		String result = "";
		
		for( Character el : input.toCharArray())
		{
			result = Character.isLowerCase(el) ? result.concat(el.toString()) : result.concat(" "+el.toString());
		}
		
	    return result;
	  }
}

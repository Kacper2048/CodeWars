
public class Kata {
	
	
	public static String getMiddle(String word) {
		int halfSize = word.length()/2;
		return(word.length() % 2) == 0 ? 
	    		( String.valueOf(word.charAt(halfSize-1)) + String.valueOf(word.charAt(halfSize))) 
	    		: String.valueOf(word.charAt((halfSize)));
	  }
	
	
	public static void main(String args[])
	{
		assertEquals("es", Kata.getMiddle("test"));
	    assertEquals("dd", Kata.getMiddle("middle"));
	    assertEquals("t", Kata.getMiddle("testing"));
	    assertEquals("A", Kata.getMiddle("A"));
	}
	
	private static void assertEquals(String answer, String respond)
	{
		if (answer.equals(respond))
		{
			System.out.println("OK");
		}
		else
		{
			System.out.println("Not OK with : " + answer + " - " + respond);
		}
	}
}

public class Kata {
	
    public static void main(String args[])
    {
    	xxx();
    	return;
    }
    
    public static int findShort(String str)
    {
    	String theShort = str;
    	
		for( String el : str.split(" ") ) 
		{
			if( theShort.length() > el.length()) {
    			theShort = el;
    		}
    	}

    	return theShort.length();
    }
    
    public static void assertEquals(int exp, int ans)
    {
    	if(exp == ans){
    		
    		System.out.println("OK");
    		
    	} else {
    		
    		System.out.print("Not OK with:");
    		System.out.print(ans + " | " + exp);
    		
    	}
    	
    }
    
    static public void xxx() {
        assertEquals(3, Kata.findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, Kata.findShort("turns out random test cases are easier than writing out basic ones"));
        assertEquals(2, Kata.findShort("Let's travel abroad shall we"));
    }
}
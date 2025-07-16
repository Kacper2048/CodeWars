import java.util.Map;
import java.util.ArrayList;
public class Parser {
    
	public static int parseInt(String numStr) {
    	Map<String, Integer> numberMap = Map.ofEntries(
    		    Map.entry("zero", 0),
    		    Map.entry("one", 1),
    		    Map.entry("two", 2),
    		    Map.entry("three", 3),
    		    Map.entry("four", 4),
    		    Map.entry("five", 5),
    		    Map.entry("six", 6),
    		    Map.entry("seven", 7),
    		    Map.entry("eight", 8),
    		    Map.entry("nine", 9),
    		    Map.entry("ten", 10),
    		    Map.entry("eleven", 11),
    		    Map.entry("twelve", 12),
    		    Map.entry("thirteen", 13),
    		    Map.entry("fourteen", 14),
    		    Map.entry("fifteen", 15),
    		    Map.entry("sixteen", 16),
    		    Map.entry("seventeen", 17),
    		    Map.entry("eighteen", 18),
    		    Map.entry("nineteen", 19),
    		    Map.entry("twenty", 20),
    		    Map.entry("thirty", 30),
    		    Map.entry("forty", 40),
    		    Map.entry("fifty", 50),
    		    Map.entry("sixty", 60),
    		    Map.entry("seventy", 70),
    		    Map.entry("eighty", 80),
    		    Map.entry("ninety", 90),
    		    Map.entry("hundred", 100),
    		    Map.entry("thousand", 1000),
    		    Map.entry("million", 1000000)
    		);
    	
    	ArrayList<String> array = new ArrayList<>();
    	
    	String [] temp = numStr.split(" ");
    	//also check if number is bigger than 100 000
    	for( int i=0; i< temp.length; i++)
    	{
    		if(!temp[i].equals("and"))
    		{
    		  array.add(temp[i]);
    		}
    	}
    	int val = 0;
    	int res = 0;
    	String[] x = new String[]{};
    	
    	for( String num : array)
    	{
    		switch(num)
    		{
    		case "million" : { val = 1_000_000; } break;
    		case "thousand" : {  res = res + val * 1000; val = 0;   } break;
    		case "hundred" : {  val = val * 100;} break;
    		
    		default: {
    			x = num.split("-");
    			if(x.length == 2)
    			{
    				
    				val = val + numberMap.get(x[0]) + numberMap.get(x[1]);
    			}
    			else
    			{
    				val = val + numberMap.get(x[0]);
    			}
    		}
    		}
    	}
    	
        return val + res;
    }

    
    static public void main(String args[])
    {
    	fixedTests();
    	basicTests(); 
    }
	public static void assertEquals(int exp, int ans)
	{
		
		if(exp == ans){
			System.out.println("OK");
		}
		else{
			System.out.println("Not OK with: " + ans + " | " + exp);
		}

	}
	    
    static public void fixedTests() {
        assertEquals(1 , Parser.parseInt("one"));
        assertEquals(20 , Parser.parseInt("twenty"));
        assertEquals(246 , Parser.parseInt("two hundred forty-six"));
    }
    
    static public void basicTests() {
        assertEquals(0, Parser.parseInt("zero"));
        assertEquals(1, Parser.parseInt("one"));
        assertEquals(10, Parser.parseInt("ten"));
        assertEquals(15, Parser.parseInt("fifteen"));
        assertEquals(20, Parser.parseInt("twenty"));
        assertEquals(21, Parser.parseInt("twenty-one"));
        assertEquals(30, Parser.parseInt("thirty"));
        assertEquals(46, Parser.parseInt("forty-six"));
        assertEquals(99, Parser.parseInt("ninety-nine"));
        assertEquals(100, Parser.parseInt("one hundred"));
        assertEquals(101, Parser.parseInt("one hundred and one"));
        assertEquals(115, Parser.parseInt("one hundred fifteen"));
        assertEquals(200, Parser.parseInt("two hundred"));
        assertEquals(246, Parser.parseInt("two hundred forty-six"));
        assertEquals(300, Parser.parseInt("three hundred"));
        assertEquals(999, Parser.parseInt("nine hundred ninety-nine"));
        assertEquals(1000, Parser.parseInt("one thousand"));
        assertEquals(1234, Parser.parseInt("one thousand two hundred thirty-four"));
        assertEquals(3005, Parser.parseInt("three thousand five"));
        assertEquals(70000, Parser.parseInt("seventy thousand"));
        assertEquals(783919, Parser.parseInt("seven hundred eighty-three thousand nine hundred and nineteen"));
        assertEquals(1000000, Parser.parseInt("one million"));
        assertEquals(100000, Parser.parseInt("one hundred thousand"));
    }
    
}
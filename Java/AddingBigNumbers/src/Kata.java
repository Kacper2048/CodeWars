import java.util.ArrayList;

public class Kata {
	/*
	 * 
	 * 
	 * public static String add(String a, String b) {
	  
	  ArrayList<Integer> result = new ArrayList<>();
	  String temp;
	  
	if(a.length() < b.length())
	{
		temp = a;
		a = b;
		b = temp;
	}
	
	for(int i = 0; i < a.length(); i++)
	{
		result.add(Character.getNumericValue(a.charAt(i)));
	}
	
	int aI = a.length()-1;
	int bI = b.length()-1;
	
	int newNum = 0;
	int res = 0;
	
	while(aI >= 0)
	{
		newNum =  result.get(aI) + ((bI >= 0) ? Character.getNumericValue(b.charAt(bI)) : 0 );

		if((newNum >= 10) && aI > 0)
		{
			res = newNum % 10;
			newNum = (int)Math.floor( (newNum)/10.0);
			result.set(aI, res);
			result.set(aI-1, result.get(aI-1) + newNum);
		}
		else if(newNum >= 10)
		{
			res = newNum % 10;
			newNum = (int)Math.floor( (newNum)/10.0);
			result.set(aI, res);
			result.add(0, newNum);
		}
		else
		{
			result.set(aI, newNum);
		}
		
		aI--;
		bI--;
	}
	
	//System.out.println(result.toString().replace(", ", "").replace("[", "").replace("]", ""));
    return result.toString().replace(", ", "").replace("[", "").replace("]", "");
  }
  
	 */
	
  public static String add(String a, String b) {
	  
	ArrayList<Integer> result = new ArrayList<>();
	String temp;
	  
	if (a.length() > 1 && a.charAt(0) == '0') 
	{
		 a = a.substring(1);
	}
	
	if (b.length() > 1 && b.charAt(0) == '0') 
	{
	    b = b.substring(1);
	}
	  
	if(a.length() < b.length())
	{
		temp = a;
		a = b;
		b = temp;
	}
	
	for(int i = 0; i < a.length(); i++)
	{
		result.add(Character.getNumericValue(a.charAt(i)));
	}
	
	int aI = a.length()-1;
	int bI = b.length()-1;
	
	int newNum = 0;
	
	while(aI >= 0)
	{
		newNum =  result.get(aI) + ((bI >= 0) ? Character.getNumericValue(b.charAt(bI)) : 0 );
		
		result.set(aI, newNum % 10);
		
		if(newNum >= 10)
		{
			newNum = (int)Math.floor( (newNum)/10.0);
			
			if(aI > 0)
			{
				result.set(aI-1, result.get(aI-1) + newNum);
			}
			else
			{
				result.add(0, newNum);
			}
		}
		aI--;
		bI--;
	}
	
    return result.toString().replace(", ", "").replace("[", "").replace("]", "");
  }
  
  public static void main(String args[])
  {
	  x(add("1"   , "1")  ,    "2");
	  x(add("123" , "456"),    "579");
	  x(add("888" , "222"),    "1110");
	  x(add("1372", "69") ,    "1441");
	  x(add("12"  , "456"),    "468");
	  x(add("100" , "101"),    "201");
	  x(add("63829983432984289347293874", "90938498237058927340892374089"), "91002328220491911630239667963");
	  x(add("32965949", "01095819000523144595849"), "1095819000523177561798");
	  x(add("049969508149850541" , "863937031812072859"), "913906539961923400");
  }
  
  public static void x(String ans, String exp)
  {
	  if( exp.equals(ans))
	  {
		  System.out.println("OK");
	  }
	  else
	  {
		  System.out.println("---" + exp + " | " + ans);
	  }
  }
  
}
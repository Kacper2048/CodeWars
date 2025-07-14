public class SecureTester{
  
  //"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
	
  public static boolean alphanumeric(String s){
	  
	  String codes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	  if( s.isEmpty())
	  {
		  return false;
	  }
	  for( char el : s.toCharArray())
	  {
		  if( codes.indexOf(el) == -1)
		  {
			  return false;
		  }
	  }
	  return true;
  }
  
  static public void assertTrue()
  {
	  testValidInput(
		  new String[] {
		  "",
		  "with space",
		  "with_underscore",
		  "punctuation.",
		  "naïve",
		  "１strangedigit",
		  "emoji😊"
		  },
		  
		  new boolean[] {
				  false,
				  false,
				  false,
				  false,
				  false,
				  false,
				  false
		  }
		  );
  }
  static public void main(String args[])
  {
	  assertTrue();
  }
  
  static public void testValidInput(String [] args, boolean [] ans)
  {
	  for( int i=0; i< args.length; i++)
	  {
		  if( alphanumeric(args[i]) == ans[i])
		  {
			  System.out.println("OK");
		  }
		  else
		  {
			  System.out.println("Not OK with: " + args[i] + " | " + ans[i]);
		  }
	  }
  }
  

}
public class Kata
{
	/*
  public static char findMissingLetter(char[] array)
  {
	  char prevC = array[0];
	  
	  for( char x : array) {
		  if((x - prevC)> 1) {
			  return (char)(prevC + 1);
		  }
		  prevC = x;
	  }
    return ' ';
  }
  */
	
	public static char findMissingLetter(char[] array) {
	    for (int i = 1; i < array.length; i++) {
	        if (array[i] - array[i - 1] > 1) {
	            return (char)(array[i - 1] + 1);
	        }
	    }
	    return ' '; 
	}
	
  static public void main(String args[])
  {
	  exampleTests();
	  return;
  }
  
  static public void assertEquals(char exp, char ans)
  {
	  if( exp == ans)
	  {
		  System.out.println("OK");
	  }
	  else
	  {
		  System.out.println("Not OK with: " + exp + " | " + ans);
	  }
  }
  
  static public void exampleTests() {
      assertEquals('e', Kata.findMissingLetter(new char[] { 'a','b','c','d','f' }));
      assertEquals('P', Kata.findMissingLetter(new char[] { 'O','Q','R','S' }));
  }
}
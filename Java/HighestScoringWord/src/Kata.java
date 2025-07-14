import java.util.Arrays;
import java.util.Comparator;

public class Kata {

	/*
	 * 
	 * public static String high(String s) {
    
	 final char pivot = '`';
	 String word = null;
	 int higestScore = -1;
	 int tempScore = -1;
	
	 for( String el : s.split(" ")) {
		 tempScore = 0;
		 for(char character : el.toCharArray()) {
			 tempScore = tempScore + (character - pivot);
		 }
		 
		 if(tempScore > higestScore) {
			 higestScore = tempScore;
			 word = el;
		 }
	 }
    return word;
  	}
	 */
	public static String high(String s) {
	    return Arrays.stream(s.split(" "))
	        .max(Comparator.comparingInt(word -> word.chars().map(c -> c - '`').sum()))
	        .orElse("");
	}
  
  static  public void assertEquals(String exp, String result)
  {
	  if(exp.equals(result))
	  {
		  System.out.println("OK");
	  }
	  else
	  {
		  System.out.println("Not OK with: " + exp + " | " + result );
	  }
  }
  
  static public void main(String args[])
  {
	  sampleTests();
	  return;
  }
  
  static public void sampleTests() {
      assertEquals("taxi", Kata.high("man i need a taxi up to ubud"));
      assertEquals("volcano", Kata.high("what time are we climbing up to the volcano"));
      assertEquals("semynak", Kata.high("take me to semynak"));
      assertEquals("aa", Kata.high("aa b"));
      assertEquals("b", Kata.high("b aa"));
      assertEquals("bb", Kata.high("bb d"));
      assertEquals("d", Kata.high("d bb"));
      assertEquals("aaa", Kata.high("aaa b"));
    }

}
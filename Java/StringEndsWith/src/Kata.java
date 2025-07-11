

public class Kata {
	
  public static boolean solution(String str, String ending) {
	  
	  return str.endsWith(ending);
  }
  
  public static void check(String str, String end, boolean result)
  {
	  
	  if(solution(str, end) == result)
	  {
		  System.out.printf("OK for %s : %s\n", str,end);
	  }
	  else
	  {
		  System.out.printf("~!ERROR!~ for %s : %s\n", str,end);
	  }
	  
  }
  
  public static void staticTests() {
      check("samurai", "ai", true);
      check("sumo", "omo", false);
      check("ninja", "ja", true);
      check("sensei", "i", true);
      check("samurai", "ra", false);
      check("abc", "abcd", false);
      check("abc", "abc", true);
      check("abcabc", "bc", true);
      check("ails", "fails", false);
      check("fails", "ails", true);
      check("this", "fails", false);
      check("this", "", true);
      check(":-)", ":-(", false);
      check("!@#$%^&*() :-)", ":-)", true);
      check("abc\n", "abc", false);
  }
  
  public static void main(String args[])
  {
	  staticTests();
  }
  
  
}
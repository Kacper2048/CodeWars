import java.util.List;
import java.util.ArrayList;


class isogram {
	
  
	static public boolean isIsogram(String str){
		if(str.isEmpty()) {
			return true;
		}
      
    	ArrayList<Character> temp = new ArrayList<Character>();
    	
    	for( int i =0; i < str.length(); i++) {
    		Character c = str.toLowerCase().charAt(i); //autoboxing
    		for( char element : temp) {
    			if(element == c){
    				return false;
    			}
    		}
    		temp.add(c);
    	}
    	return true;
    }
     
  
   
   static private void assertEquals(boolean result, boolean input)
   {
	   if(result == input)
	   {
		   System.out.println("OK");
	   }
   }
   
   public static void main(String args[])
   {
	   assertEquals(true, isogram.isIsogram("Dermatoglyphics"));
       assertEquals(true, isogram.isIsogram("isogram"));
       assertEquals(false, isogram.isIsogram("moose"));
       assertEquals(false, isogram.isIsogram("isIsogram"));
       assertEquals(false, isogram.isIsogram("aba"));
       assertEquals(false, isogram.isIsogram("moOse"));
       assertEquals(true, isogram.isIsogram("thumbscrewjapingly"));
       assertEquals(true, isogram.isIsogram("")); 
   }
   
}
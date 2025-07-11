import java.util.List;
import java.util.ArrayList;
class Kata {
	
   public static List<String> friend(List<String> people){
	   
	 ArrayList<String> friend = new ArrayList<String>();
	 
     for( String element : people){
    	if( (double)(element.length()) / 4.00 == 1.00) {
    		friend.add(element);
    	} 
     }
   	return (List<String>)friend;
   }
     
     
  
   
   static private void assertEquals(List<String> result, List<String> input)
   {
	   ArrayList<String> respond = new ArrayList(friend(input));
	   if( result == respond)
	   {
		   System.out.println("OK");
	   }
	   else
	   {
		   System.out.print("Not OK with: ");
		   
		   for( String element : result)
		   {
			   System.out.print(element + ", ");
		   }
		   System.out.print(" | ");
		   for( String element : respond)
		   {
			   System.out.print(element + ", ");
		   }
		   System.out.println("");
	   }
   }
   
   public static void main(String args[])
   {
	   assertEquals(List.of("Ryan", "Yous"), List.of("Ryan", "Kieran", "Jason", "Yous"));
       assertEquals(List.of(), List.of("Peter", "Stephen", "Joe"));
   }
   
}
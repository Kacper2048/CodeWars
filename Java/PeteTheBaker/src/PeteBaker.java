import java.util.Map;

public class PeteBaker {
  public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
	  /*
	   public class PeteBaker {
		  public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
			  
			  if(available.keySet().containsAll(recipe.keySet()))
			  {
				 return recipe.keySet().stream().mapToInt( (k) -> {
					 return (int)(Math.floor(available.get(k) / recipe.get(k))); }).min()
						    .orElse(0);
			  }
			  else
			  {
				  return 0;
			  }
		
		  }
	   */
	  return available.keySet().containsAll(recipe.keySet()) ? 
	  
		  recipe.keySet()
		  .stream()
		  .mapToInt( 
				  (k) -> {
				  	return (int)(Math.floor(available.get(k) / recipe.get(k))); 
		  })
		  .min()
		  .orElse(0)
	  : 
		  0;
  }
  public static void assertEquals(int exp, int ans, String x)
  {
	  if(exp == ans)
	  {
		  System.out.println("OK");
	  }
	  else
	  {
		  System.out.println("Not OK with " + exp + " | " + ans);
	  }
  }
  
  static public void main(String args[])
  {
	  basicTest();
	  missingIngredient();
  }
	   
	    public static void basicTest() {
	        Map<String, Integer> recipe = Map.of(
	            "flour", 500,
	            "sugar", 200,
	            "eggs", 1);
	        Map<String, Integer> available = Map.of(
	            "flour", 1200,
	            "sugar", 1200,
	            "eggs", 5,
	            "milk", 200);
	        
	        assertEquals(2, PeteBaker.cakes(recipe, available), "For recipe " + recipe + " and ingredients " + available);
	    }
	    
	
	   public static void missingIngredient() {
	        Map<String, Integer> recipe = Map.of(
	            "flour", 500,
	            "sugar", 200,
	            "eggs", 1,
	            "cinnamon", 300);
	        Map<String, Integer> available = Map.of(
	            "flour", 1200,
	            "sugar", 1200,
	            "eggs", 5,
	            "milk", 200);
	        assertEquals(0, PeteBaker.cakes(recipe, available), "For recipe " + recipe + " and ingredients " + available);
	    }


}
import java.util.*;
import java.util.stream.*;

public class TopWords {
    
	public static List<String> top3(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }

       
        String[] filteredWords = s.toLowerCase().split("[^a-z']+");

        
        String[] words = Arrays.stream(filteredWords)
                .filter(word -> !word.isBlank() && !word.replace("'", "").isEmpty())
                .toArray(String[]::new);

        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String key : words) {
            wordCount.put(key, wordCount.getOrDefault(key, 0) + 1);
        }

        
        List<String> sorted = wordCount.entrySet()
                .stream()
                .sorted(
                	    Comparator.<Map.Entry<String, Integer>, Integer>comparing(Map.Entry::getValue, Comparator.reverseOrder())
                	    .thenComparing(Map.Entry::getKey)
                	)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

       
        return sorted.stream().limit(3).collect(Collectors.toList());
    }
    
    public static void text(String input, List<String> expected) {
        List<String> actual = TopWords.top3(input);

        if (!actual.equals(expected)) {
            System.out.println("Test failed!");
            System.out.println("Input: " + input);
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
        } else {
            System.out.println("Test passed.");
        }
        System.out.println();
    }

    public static void main(String[] args) {
      
        text("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e", List.of("e", "ddd", "aa"));
        text("  //wont won't won't ", List.of("won't", "wont"));
        text("  , e   .. ", List.of("e"));
        text("  ...  ", List.of());
        text("  '  ", List.of());
        text("  '''  ", List.of());
        text("'a 'A 'a' a'A' a'a'!", List.of("'a", "a'a'", "'a'"));
        text("""
             In a village of La Mancha, the name of which I have no desire to call to
             mind, there lived not long since one of those gentlemen that keep a lance
             in the lance-rack, an old buckler, a lean hack, and a greyhound for
             coursing. An olla of rather more beef than mutton, a salad on most
             nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra
             on Sundays, made away with three-quarters of his income.""",
             List.of("a", "of", "on"));
    }
}
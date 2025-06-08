import java.util.*;

class Solution {
    
    private static final char[] arr = "AEIOU".toCharArray();
    
    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate(words, "");
        return words.indexOf(word);
    }
    
    private void generate(List<String> words, String word) {
        
        words.add(word);
        
        if(word.length() == 5) return;
        
        for(int i = 0; i < 5; i++) {
            generate(words, word + arr[i]);
        }
    }
}
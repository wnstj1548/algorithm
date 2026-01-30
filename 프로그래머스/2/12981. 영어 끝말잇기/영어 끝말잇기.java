import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        
        String firstWord = words[0];

        char lastWordChar = firstWord.charAt(firstWord.length() -1);
        int wrong = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put(firstWord, 1);
        
        for(int i = 1; i < words.length; i++) {
            
            String word = words[i];
            
            if(lastWordChar != word.charAt(0)) {
                wrong = i;
                break;
            }
            
            map.putIfAbsent(word, 0);
            map.put(word, map.get(word) + 1);
            
            if(map.get(word) != 1) {
                wrong = i;
                break;
            }
                        
            lastWordChar = word.charAt(word.length() -1);
        }
        
        if(wrong == 0) {
            return new int[]{0, 0};
        } else {
            int turn = (wrong / n) + 1;
            int person = (wrong % n) + 1;
            
            return new int[]{person, turn};
        }
    }
}

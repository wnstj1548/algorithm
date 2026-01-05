import java.util.*;

class Solution {
    public int solution(String before, String after) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(Character c : before.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        
        for(Character c : after.toCharArray()) {
            if(map.get(c) == null || map.get(c) == 0) {
                return 0;
            }
            
            map.put(c, map.get(c) -1);
        }
        
        return 1;
    }
}
import java.util.*;

class Solution {
    public int solution(String s) {
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i <=s.length(); i++) {
            
            int result = compress(s, i);
            if(result < min) {
                min = result;
            }
        }
        
        return min;
    }
    
    private int compress(String s, int length) {
        List<String> tokens = splitToken(s, length);
        StringBuilder sb = new StringBuilder();
        
        String last = "";
        int count = 0;
        
        for(String token : tokens) {
            if(token.equals(last)) {
                count++;
            } else {
                if (count > 1) sb.append(count);
                sb.append(last);
                last = token;
                count = 1;
            }
        }
        
        if(count > 1) sb.append(count);
        sb.append(last);
        
        return sb.length();
    }
    
    private List<String> splitToken(String s, int length) {
        
        List<String> tokens = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i = i+length) {
            int endIndex = i+length < s.length() ? i+length : s.length();
            tokens.add(s.substring(i, endIndex));
        }
        
        return tokens;
    }
}
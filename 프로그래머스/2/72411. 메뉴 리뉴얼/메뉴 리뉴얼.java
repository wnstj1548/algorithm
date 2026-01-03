import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    private Map<String, Integer> countMap = new HashMap<>();
    
    private void comb(char[] arr, int depth, StringBuilder sb) {
        
        if(sb.length() >= 2) {
            String key = sb.toString();
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }
        
        for(int i = depth; i < arr.length; i++) {
            sb.append(arr[i]);
            comb(arr, i + 1, sb);
            sb.deleteCharAt(sb.length() -1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        
        Set<String> result = new HashSet<>();
        
        for(String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            comb(arr, 0, new StringBuilder());
        }
        
        for(int len : course) {
            int max = 0;
            for(String key : countMap.keySet()) {
                if(key.length() == len) {
                    if(countMap.get(key) > max) {
                        max = countMap.get(key);
                    }
                }
            }
            
            if(max >= 2) {
                for(String key : countMap.keySet()) {
                    if(key.length() == len && countMap.get(key) == max) {
                        result.add(key);
                    }
                }
            }
        }
        
        String[] answer = result.stream().sorted().toArray(String[]::new);
        return answer;
    }
}
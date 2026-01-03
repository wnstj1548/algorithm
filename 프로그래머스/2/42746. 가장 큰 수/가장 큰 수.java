import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        
        Comparator<Integer> comp = (n1, n2) -> {
            String temp1 = String.valueOf(n1);
            String temp2 = String.valueOf(n2);
            
            Integer v1 = Integer.parseInt(temp1 + temp2);
            Integer v2 = Integer.parseInt(temp2 + temp1);
            
            return v2 - v1;
        };
        
        Arrays.sort(nums, comp);
        
        StringBuilder sb = new StringBuilder();
        
        for(int n : nums) {
            sb.append(n + "");
        }
        
        String answer = sb.toString();
        
        if(answer.startsWith("0")) {
            return "0";
        }
        
        return answer;
    }
}
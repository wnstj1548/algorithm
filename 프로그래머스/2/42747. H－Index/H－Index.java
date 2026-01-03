import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        int n = citations.length;
        
        for(int i = citations.length; i >= 1; i--) {
            int index = n-i;
            if(citations[index] >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        long start = 0L;
        long end = (long)distance;
        
        Arrays.sort(rocks);
        
        while(start <= end) {
            long count = 0L;
            long previous = 0L;
            long mid = (start + end) / 2;
            
            for(int rock : rocks) {
                if(rock - previous < mid) {
                    count++;
                    continue;
                }
                previous = (long)rock;
            }
            
            if((long)distance - previous < mid) {
                count++;
            }
            
            if (count <= n) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        
        return (int) end;
    }
}
class Solution {
    
    public long solution(int n, int[] times) {
        
        long start = 1L;
        long end = (long)n * 1000000000L;
        
        while(start < end) {
            long mid = (start + end) / 2;
            
            long sum = 0;
            
            for(int time : times) {
                sum += mid / time;
            }
            
            if(sum < n) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}
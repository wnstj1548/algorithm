import java.util.*;

class Solution {
    
    private int[] arr = new int[100001];
    
    private int fibonacci(int n) {
        
        if(n == 0) {
            return 0;
        }
        
        if(n == 1) {
            return 1;
        }
        
        if(arr[n] != -1) {
            return arr[n];
        }
        
        arr[n] = (fibonacci(n-1) + fibonacci(n-2)) % 1234567;
        
        return arr[n];
    }
    
    public int solution(int n) {
        
        Arrays.fill(arr, -1);
        
        return fibonacci(n);
    }
}
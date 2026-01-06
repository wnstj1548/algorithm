import java.util.*;

class Solution {
    
    private static final int MOD = 1000000007;
    
    private int dp(int[][] mem, int m, int n) {
        
        if(m <= 0 || n <= 0 || mem[m][n] == -1) return 0;
        
        if(mem[m][n] == 0) {
            mem[m][n] = (dp(mem, m-1, n) + dp(mem, m, n-1)) % MOD;
        }
        
        return mem[m][n];
    }
    
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] mem = new int[101][101];
        
        for(int[] temp : mem) {
            Arrays.fill(temp, 0);
        }
        
        for(int[] puddle : puddles) {
            mem[puddle[0]][puddle[1]] = -1;
        }
        
        mem[1][1] = 1;
        
        return dp(mem, m, n);
    }
}
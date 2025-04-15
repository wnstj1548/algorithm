import java.util.*;

class Solution {
    
    private void hanoi(int n, int from, int to, List<int[]> result) {
        
        if(n == 1) {
            result.add(new int[]{from, to});
            return;
        }
        
        int empty = 6 - from - to;
        hanoi(n-1, from, empty, result);
        hanoi(1, from, to, result);
        hanoi(n-1, empty, to, result);
    }
    
    public int[][] solution(int n) {
        
        List<int[]> result = new ArrayList<>();
        
        hanoi(n, 1, 3, result);
        
        int[][] answer = result.toArray(new int[result.size()][]);
        return answer;
    }
}
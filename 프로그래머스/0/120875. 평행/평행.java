import java.util.*;

class Solution {
    
    public int solution(int[][] dots) {
        
        if(slope(dots, 0, 1) == slope(dots, 2, 3)) {
            return 1;
        }
        
        if(slope(dots, 0, 2) == slope(dots, 1, 3)) {
            return 1;
        }
        
        if(slope(dots, 1, 2) == slope(dots, 0, 3)) {
            return 1;
        }
        
        return 0;
    } 
    
    private double slope(int[][] dots, int i, int ii) {
        return (double) (dots[ii][1] - dots[i][1]) / (dots[ii][0] - dots[i][0]);
    }
}
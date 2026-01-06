class Solution {
    public int solution(int[][] triangle) {
        
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                
                if(j > 0 && j <= triangle[i-1].length -1) {
                    triangle[i][j] = triangle[i][j] + Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                    continue;
                }
                
                if(j > 0) {
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
                    continue;
                }
                
                if(j <= triangle[i-1].length -1) {
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j];
                    continue;
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i : triangle[triangle.length -1]) {
            if (max < i) {
                max = i;
            }
        }
        
        return max;
    }
}
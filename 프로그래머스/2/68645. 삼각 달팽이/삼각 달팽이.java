class Solution {
    
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};
    
    public int[] solution(int n) {
        
        int[][] arr = new int[n][n];
        
        int count = 1;
        int pos = 0;
        int nowX = 0;
        int nowY = 0;
        
        while(true) {
            
            arr[nowY][nowX] = count++;
            
            int nx = nowX + dx[pos];
            int ny = nowY + dy[pos];
            
            if(nx == n || ny == n || nx < 0 || ny < 0 || arr[ny][nx] != 0) {
                
                pos = (pos + 1) % 3;
                
                nx = nowX + dx[pos];
                ny = nowY + dy[pos];
                
                if(nx == n || ny == n || nx < 0 || ny < 0 || arr[ny][nx] != 0) break;
            } 
            
            nowX = nx;
            nowY = ny;
        }
        
        int index = 0;
        int[] answer = new int[count-1];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[index++] = arr[i][j];
            }
        }
        
        return answer;
    }
}
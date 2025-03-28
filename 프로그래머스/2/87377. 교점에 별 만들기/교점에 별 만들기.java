import java.util.*;

class Solution {
    
    private static class Point {
        
        private final long x, y;
        
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private Point calculate(long x1, long y1, long z1, long x2, long y2, long z2) {
        
        double x = (double) (y1 * z2 - y2 * z1) / (x1 * y2 - x2 * y1);
        double y = (double) (x2 * z1 - x1 * z2) / (x1 * y2 - x2 * y1);
        
        if(x % 1 == 0 && y % 1 == 0) return new Point((long) x, (long) y);
        
        return null;
    }
    
    public String[] solution(int[][] line) {
        
        List<Point> pointList = new ArrayList<>();
        
        for(int i = 0; i < line.length -1; i++) {
            for(int j = i+1; j < line.length; j++) {
                
                Point point = calculate(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                
                if(point != null) {
                    pointList.add(point);
                }
            }
        }
        
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        
        for(Point p : pointList) {
            if(p.x > maxX) {
                maxX = p.x;
            }
            
            if(p.y > maxY) {
                maxY = p.y;
            }
            
            if(p.x < minX) {
                minX = p.x;
            }
            
            if(p.y < minY) {
                minY = p.y;
            }
        }
        
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        
        char[][] arr = new char[height][width];
        
        for(char[] row : arr) {
            Arrays.fill(row, '.');
        }
        
        for(Point p : pointList) {
            int x = (int) (p.x - minX);
            int y = (int) (maxY - p.y);
            arr[y][x] = '*';
        }
        
        String[] answer = new String[arr.length];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }
        
        return answer;
    }
}
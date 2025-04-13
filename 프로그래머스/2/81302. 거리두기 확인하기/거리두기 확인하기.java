class Solution {
    
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    
    private boolean isDistanced(char[][] room) {
        for(int y = 0; y < 5; y++) {
            for(int x = 0; x < 5; x++) {
                if(room[y][x] == 'P') {
                    for(int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        
                        if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                            if(room[ny][nx] == 'P') {
                                return false;
                            } else if (room[ny][nx] == 'X') {
                                continue;
                            } else {
                                for(int d2 = 0; d2 < 4; d2++) {
                                    int nx2 = nx + dx[d2];
                                    int ny2 = ny + dy[d2];
                                    
                                    if(nx2 >= 0 && ny2 >= 0 && nx2 < 5 && ny2 < 5) {
                                        
                                        if(nx2 == x && ny2 == y) {
                                            continue;
                                        }
                                        
                                        if(room[ny2][nx2] == 'P') {
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
            String[] place = places[i];
            char[][] room = new char[5][5];
            
            for(int j = 0; j < 5; j++) {
                room[j] = place[j].toCharArray();
            }
            
            if(isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
}
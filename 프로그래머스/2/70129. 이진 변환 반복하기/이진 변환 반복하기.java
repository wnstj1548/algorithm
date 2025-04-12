class Solution {
    
    public void recur(String s, int[] answer) {
        
        if(s.equals("1")) {
            return;
        }
        
        answer[0]++;
        int oneCount = 0;
        
        for(char c : s.toCharArray()) {
            if(c == '0') {
                answer[1]++;
            } else {
                oneCount++;
            }
        }
        
        String next = Integer.toString(oneCount, 2);
        recur(next, answer);
    }
    
    public int[] solution(String s) {
        
        int[] answer = {0, 0};

        recur(s, answer);
        
        return answer;
    }
}
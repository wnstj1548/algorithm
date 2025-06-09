import java.util.*;

class Solution {
    
    private int[][] METHOD = {
        {1,2,3,4,5},
        {2,1,2,3,2,4,2,5},
        {3,3,1,1,2,2,4,4,5,5}
    };
    
    private int pickedAnswer(int person, int problem) {
        int picked = problem % METHOD[person].length;
        return METHOD[person][picked];
    }
    
    public int[] solution(int[] answers) {
        
        int[] corrects = new int[3];
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < 3; i++) {
            for(int ii=0; ii < answers.length; ii++) {
                if(pickedAnswer(i, ii) == answers[ii]) {
                    corrects[i]++;
                }
            }
            
            if(corrects[i] > max) {
                max = corrects[i];
            }
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            if(corrects[i] == max) {
                answerList.add(i);
            }
        }
        
        int[] result = new int[answerList.size()];
        
        for(int i=0; i < answerList.size(); i++) {
            result[i] = answerList.get(i) + 1;
        }
        
        return result;
    }
}
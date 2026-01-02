class Solution {
    public int[] solution(int brown, int yellow) {
        
        //브라운 = 2 * (width + height -2)
        //옐로우 = (width - 2) * (height -2)
        
        int[] answer = {};
        
        for(int width = 3; width <= 5000; width++) {
            for(int height = 3; height <= width; height++) {
                if(2 * (width + height -2) == brown && (width -2) * (height - 2) == yellow) {
                    answer = new int[] {width, height};
                }
            }
        }
        return answer;
    }
}
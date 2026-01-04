import java.util.*;

class Solution {
    
    private static Map<String, List<Integer>> map = new HashMap<>();
    
    private static void combination(int depth, String[] selected, String key) {
            
        if(depth == 4) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(Integer.parseInt(selected[4]));
            return;
        }

        combination(depth + 1, selected, key + selected[depth]);
        combination(depth + 1, selected, key + "-");
    }
    
    private static int binarySearch(List<Integer> scoreList, int score) {
        
        int start = 0;
        int end = scoreList.size();
        
        while(start < end) {
            int mid = (start + end) / 2;
            
            if(scoreList.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return scoreList.size() - start;
    }
    
    public int[] solution(String[] info, String[] query) {
        
        int[] answer = new int[query.length];
        
        for(String inf : info) {
            String[] selected = inf.split(" ");
            combination(0, selected, "");
        }
        
        for(List<Integer> list : map.values()) {
            Collections.sort(list);
        }
        
        for(int j = 0; j < query.length; j++) {
            String[] selectedQuery = query[j].replace(" and ", " ").split(" ");
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < 4; i++) {
                sb.append(selectedQuery[i]);
            }
            
            String key = sb.toString();
            int score = Integer.parseInt(selectedQuery[4]);
            List<Integer> scoreList = map.get(key);
            
            if(scoreList == null) {
                answer[j] = 0;
                continue;
            }
            
            answer[j] = binarySearch(scoreList, score);
        }
    
        return answer;
    }
}
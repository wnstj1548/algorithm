import java.util.*;
import java.util.stream.*;

class Solution {
    
    private static void count(List<List<String>> banList, Set<Set<String>> result, int depth, Set<String> now) {
        
        if(banList.size() == now.size()) {
            result.add(new HashSet<>(now));
            return;
        }
        
        for(String ban : banList.get(depth)) {
            if(now.contains(ban)) continue;
            now.add(ban);
            count(banList, result, depth+1, now);
            now.remove(ban);
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        
        List<List<String>> banList = Arrays.stream(banned_id)
            .map(ban -> ban.replaceAll("\\*", "."))
            .map(ban -> 
                 Arrays.stream(user_id)
                    .filter(user -> user.matches(ban))
                    .collect(Collectors.toList()))
            .collect(Collectors.toList());
        
        Set<Set<String>> result = new HashSet<>();
        
        count(banList, result, 0, new HashSet<>());
        return result.size();
    }
}
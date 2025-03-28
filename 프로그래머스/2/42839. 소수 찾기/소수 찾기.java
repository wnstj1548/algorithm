import java.util.*;

class Solution {
    
    private boolean isPrime(int value) {
        
        if(value <= 1) return false;
        
        for(int i = 2; i * i <= value; i++) {
            if(value % i == 0) return false;
        }
        
        return true;
    }
    
    private void searchPrime(Set<Integer> set, List<String> numberList, boolean[] visited, String number) {
        
        for(int i = 0; i < numberList.size(); i++) {
            
            if(visited[i]) continue;
            
            visited[i] = true;
            int value = Integer.parseInt(number+numberList.get(i));
            
            if(isPrime(value)) {
                set.add(value);
            }
            
            searchPrime(set, numberList, visited, number+numberList.get(i));
            visited[i] = false;
        }
    }
    
    public int solution(String numbers) {
        
        int size = numbers.length();
        List<String> numberList = Arrays.asList(numbers.split(""));
        boolean[] visited = new boolean[size];
        Set<Integer> set = new HashSet<>();
        
        searchPrime(set, numberList, visited, "");
        
        return set.size();
    }
}
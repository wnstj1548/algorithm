import java.util.*;

class Solution {
    
    private static final List<String[]> precedences = List.of(
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "-*+".split(""),
        "*+-".split(""),
        "*-+".split("")
    );
    
    private static long calculate(Long left, Long right, String op) {
        return switch(op) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            default -> 0L;
        };
    }
    
    private static long calculate(List<String> tokens, String[] precedences) {
        
        for(String op : precedences) {
            for(int i = 0; i < tokens.size(); i++) {
                if(op.equals(tokens.get(i))) {
                    Long left = Long.parseLong(tokens.get(i-1));
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    Long right = Long.parseLong(tokens.get(i-1));
                    tokens.remove(i-1);
                    long tempCalc = calculate(left, right, op);
                    tokens.add(i-1, String.valueOf(tempCalc));
                    i = i-2;
                }
            }
        }
        
        return Long.parseLong(tokens.get(0));
    }
    
    public long solution(String expression) {
        
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        
        while(st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        
        long answer = 0;
        
        for(String[] precedence : precedences) {
            long temp = Math.abs(calculate(new ArrayList<>(tokens), precedence));
            
            if(temp > answer) {
                answer = temp;
            }
        }
        
        return answer;
    }
}
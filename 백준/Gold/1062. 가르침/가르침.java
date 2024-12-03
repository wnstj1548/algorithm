import java.io.*;
import java.util.*;

public class Main {

    static String extract(String s) {
        return s.replace("a", "").replace("t","").replace("i", "").replace("c", "").replace("n", "");
    }

    static List<List<Character>> getCombination(Set<Character> charSet, int k) {
        List<Character> list = new ArrayList<>(charSet);
        List<List<Character>> result = new ArrayList<>();
        combination(list, new ArrayList<>(), 0, k, result);
        return result;
    }

    static void combination(List<Character> list, List<Character> temp, int start, int k, List<List<Character>> result) {

        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < list.size(); i++) {
            temp.add(list.get(i));
            combination(list, temp, i + 1, k, result);
            temp.remove(temp.size() - 1);
        }
    }

    static boolean canLearn(String word, Set<Character> learned) {
        for (char c : word.toCharArray()) {
            if (!learned.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<String> stringList = new ArrayList<>();
        Set<Character> set = new HashSet<>();

        if(k < 5) {
            bw.write(0 + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        if(k >= 26) {
            bw.write(n + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        k = k-5;

        for(int i = 0; i < n; i++) {
            String s = extract(br.readLine());
            stringList.add(s);
            for(int j = 0; j < s.length(); j++) {
                set.add(s.charAt(j));
            }
        }

        if(set.size() < k) {
            bw.write(n + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        int maxCount = 0;

        List<List<Character>> result = getCombination(set, k);

        for (List<Character> comb : result) {
            Set<Character> learned = new HashSet<>(comb);

            int count = 0;
            for (String word : stringList) {
                if (canLearn(word, learned)) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }


        bw.write(maxCount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

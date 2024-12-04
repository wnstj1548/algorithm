import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static List<Integer> getCombination(int k, List<Integer> sumList) {
        combination(k, 0, sumList, new ArrayList<>());
        return sumList;
    }

    public static void combination(int k, int start, List<Integer> result, List<Integer> temp) {

        if(k == temp.size()) {
            int sum = 0;
            for(int i : temp) {
                sum += i;
            }
            result.add(sum);
            return;
        }

        for(int i = start; i < n; i++) {
            temp.add(arr[i]);
            combination(k , i+1, result, temp);
            temp.remove(temp.size()-1);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        long count = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> resultList = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            getCombination(i, resultList);
        }

        if(!resultList.contains(m)) {
            bw.write("0\n");
        } else {
            count = resultList.stream()
                    .filter((i) -> i == m)
                    .count();

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

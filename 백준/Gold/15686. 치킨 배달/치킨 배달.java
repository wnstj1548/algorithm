import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int min = Integer.MAX_VALUE;
    static List<int[]> chickenList = new ArrayList<>();
    static List<int[]> homeList = new ArrayList<>();
    static List<int[]> tempList = new ArrayList<>();

    public static void combi(List<int[]> chickenList, int depth, int start) {

        if(depth == m) {
            min = Math.min(go(), min);
            return;
        }

        for(int i = start; i < chickenList.size(); i++) {
            tempList.add(chickenList.get(i));
            combi(chickenList, depth + 1, i + 1);
            tempList.remove(tempList.size() -1);
        }
    }

    public static int go() {

        int sum = 0;

        for(int[] home : homeList) {
            int tempMin = Integer.MAX_VALUE;
            for(int[] chicken : tempList) {
                tempMin = Math.min(tempMin, (Math.abs(chicken[0] - home[0]) + Math.abs(chicken[1] - home[1])));
            }
            sum += tempMin;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) homeList.add(new int[]{i, j});
                if(temp == 2) chickenList.add(new int[]{i,j});
            }
        }

        combi(chickenList,0, 0);

        bw.write(min + "");
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }
}
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int mp, mf, ms, mv;
    static int min = Integer.MAX_VALUE;
    static Food[] foods;
    static List<Integer> selectList = new ArrayList<>();
    static List<Integer> resultList;

    public static void combi(int nowP, int nowF, int nowS, int nowV, int nowC, int start) {

        if(nowP >= mp && nowF >= mf && nowS >= ms && nowV >= mv) {

            if(min > nowC) {
                min = nowC;
                resultList = new ArrayList<>(selectList);
            }

            return;
        }

        for(int i = start; i < n; i++) {
            nowP += foods[i].p;
            nowF += foods[i].f;
            nowS += foods[i].s;
            nowV += foods[i].v;
            nowC += foods[i].c;
            selectList.add(i + 1);
            combi(nowP, nowF, nowS, nowV, nowC, i + 1);
            nowP -= foods[i].p;
            nowF -= foods[i].f;
            nowS -= foods[i].s;
            nowV -= foods[i].v;
            nowC -= foods[i].c;
            selectList.remove(selectList.size() -1);
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        foods = new Food[n];

        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            foods[i] = new Food(p, f, s, v, c);
        }

        combi(0,0,0,0,0,0);

        if(min == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(min));
            bw.newLine();
            for(int i : resultList) {
                bw.write(i + " ");
            }
        }
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    static class Food {
        int p;
        int f;
        int s;
        int v;
        int c;

        public Food(int p, int f, int s, int v, int c) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.c = c;
        }
    }
}
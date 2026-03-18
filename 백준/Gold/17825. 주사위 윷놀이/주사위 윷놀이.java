import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dice = new int[10];
    static int[] horse = new int[4];
    static int[] score = new int[101];
    static List<Integer>[] next = new ArrayList[101];

    static void initBoard() {
        for(int i = 0; i < next.length; i++) {
            next[i] = new ArrayList<>();
        }

        for(int i = 0; i <= 19; i++) {
            next[i].add(i+1);
        }

        next[5].add(21);
        next[21].add(22);
        next[22].add(23);
        next[23].add(24);

        next[10].add(27);
        next[27].add(28);
        next[28].add(24);

        next[15].add(29);
        next[29].add(30);
        next[30].add(31);
        next[31].add(24);

        next[24].add(25);
        next[25].add(26);
        next[26].add(20);
        next[20].add(100);

        score[1] = 2;
        score[2] = 4;
        score[3] = 6;
        score[4] = 8;
        score[5] = 10;
        score[6] = 12;
        score[7] = 14;
        score[8] = 16;
        score[9] = 18;
        score[10] = 20;
        score[11] = 22;
        score[12] = 24;
        score[13] = 26;
        score[14] = 28;
        score[15] = 30;
        score[16] = 32;
        score[17] = 34;
        score[18] = 36;
        score[19] = 38;
        score[20] = 40;

        score[21] = 13;
        score[22] = 16;
        score[23] = 19;
        score[24] = 25;
        score[25] = 30;
        score[26] = 35;

        score[27] = 22;
        score[28] = 24;

        score[29] = 28;
        score[30] = 27;
        score[31] = 26;
    }

    static int move(int position, int moveCount) {
        if(position == 100) return 100;

        int current = position;

        if (next[current].size() >= 2) {
            current = next[current].get(1);
            moveCount--;
        }

        while(moveCount > 0 && current != 100) {
            current = next[current].get(0);
            moveCount--;
        }

        return current;
    }

    static boolean hasSamePosition(int target, int horseIndex) {
        if (target == 100) return false;

        for(int i = 0; i < 4; i++) {
            if(i == horseIndex) continue;
            if(horse[i] == target) return true;
        }

        return false;
    }

    static int dfs(int turn) {
        if (turn == 10) {
            return 0;
        }

        int maxScore = 0;

        for(int i = 0; i < 4; i++) {
            int originPos = horse[i];
            int movedPos = move(originPos, dice[turn]);

            if(hasSamePosition(movedPos, i)) continue;

            horse[i] = movedPos;
            maxScore = Math.max(maxScore, score[movedPos] + dfs(turn + 1));
            horse[i] = originPos;
        }

        return maxScore;
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        initBoard();
        int ret = dfs(0);

        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
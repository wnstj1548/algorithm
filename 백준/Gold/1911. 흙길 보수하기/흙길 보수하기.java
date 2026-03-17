import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, l;

    static class Board implements Comparable<Board>{
        int start;
        int end;

        public Board(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Board o) {
            if(this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int pos = 0;

        Board[] boards = new Board[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            boards[i] = new Board(start, end);
        }

        Arrays.sort(boards);

        for(Board board : boards) {
            int start = Math.max(board.start, pos);
            
            while(start < board.end) {
                cnt++;
                start += l;
            }
            
            pos = start;
        }

        bw.write(String.valueOf(cnt));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
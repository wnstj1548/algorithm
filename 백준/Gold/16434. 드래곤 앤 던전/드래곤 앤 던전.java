import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int n;
    static long atk;
    static Room[] rooms;
    static long res = Long.MAX_VALUE;

    public static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static long nextLong() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Long.parseLong(st.nextToken());
    }

    static class Room {
        int t;
        long a;
        long h;

        public Room(int t, long a, long h) {
            this.a = a;
            this.h = h;
            this.t = t;
        }
    }

    public static boolean go(long hp) {

        long nowHp = hp;
        long nowAtk = atk;

        for(int i = 0; i < n; i++) {
            Room room = rooms[i];

            if(room.t == 1) {
                long mHp = room.h;

                long cnt = mHp / nowAtk;
                if(mHp % nowAtk != 0) cnt++;

                mHp -= cnt * nowAtk;
                nowHp -= (cnt-1) * room.a;

                if(nowHp <= 0) return false;

            } else if (room.t == 2) {
                nowHp = Math.min(nowHp + room.h, hp);
                nowAtk += room.a;
            }
        }

        return nowHp > 0;
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        atk = nextLong();
        rooms = new Room[n];

        long left = 1;
        long right = Long.MAX_VALUE / 4;

        for(int i = 0; i < n; i++) {
            int t = nextInt();
            long a = nextLong();
            long h = nextLong();
            Room room = new Room(t, a, h);
            rooms[i] = room;
        }

        while(left <= right) {
            long mid = (left + right) / 2;

            if(go(mid)) {
                right = mid - 1;
                res = Math.min(mid, res);
            } else {
                left = mid + 1;
            }
        }

        bw.write(String.valueOf(res));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
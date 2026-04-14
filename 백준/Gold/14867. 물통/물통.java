import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int a, b, c, d;
    static Map<State, Integer> dist = new HashMap<>();
    static Queue<State> q = new ArrayDeque<>();

    static class State {
        int y;
        int x;

        public State(int x, int y) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof State)) return false;
            State state = (State) o;
            return x == state.x && y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static void enqueue(int x, int y, int curDist) {
        State next = new State(x, y);

        if(dist.containsKey(next)) return;

        dist.put(next, curDist+1);
        q.add(next);
    }

    static int bfs(int x, int y) {
        State start = new State(x, y);
        dist.put(start, 0);
        q.add(start);

        while(!q.isEmpty()) {
            State cur = q.poll();
            x = cur.x;
            y = cur.y;
            int curDist = dist.get(cur);

            if(x == c && y == d) return curDist;

            enqueue(a, y, curDist);
            enqueue(x, b, curDist);
            enqueue(0, y, curDist);
            enqueue(x, 0, curDist);
            enqueue(Math.min(x + y, a), Math.max(0, x + y - a), curDist);
            enqueue(Math.max(0, x + y - b), Math.min(x + y, b), curDist);
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {

        a = nextInt();
        b = nextInt();
        c = nextInt();
        d = nextInt();

        bw.write(String.valueOf(bfs(0,0)));
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }

    public static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
}
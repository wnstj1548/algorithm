import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int n, m, k;
    static int[][] a;
    static int[][] add;
    static List<Tree> trees = new ArrayList<>();
    static int[] dy = {1, 0, 0, -1, 1, 1, -1, -1};
    static int[] dx = {0, 1, -1, 0, 1, -1, 1, -1};

    static class Tree implements Comparable<Tree>{
        int y;
        int x;
        int age;
        boolean isDead;

        public Tree(int age, int x, int y) {
            this.age = age;
            this.x = x;
            this.y = y;
            isDead = false;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        m = nextInt();
        k = nextInt();
        a = new int[n+1][n+1];
        add = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            Arrays.fill(a[i], 5);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                add[i][j] = nextInt();
            }
        }

        for(int i = 0; i < m; i++) {
            int y = nextInt();
            int x = nextInt();
            int z = nextInt();
            trees.add(new Tree(z, x, y));
        }

        List<Tree> deadTrees = new ArrayList<>();
        List<Tree> temp = new ArrayList<>();

        for(int i = 0; i < k; i++) {

            trees.addAll(temp);
            temp.clear();
            Collections.sort(trees);

            for(Tree tree : trees) {
                if(tree.isDead) continue;

                if(a[tree.y][tree.x] >= tree.age) {
                    a[tree.y][tree.x] -= tree.age;
                    tree.age += 1;
                } else {
                    tree.isDead = true;
                    deadTrees.add(tree);
                }
            }

            for(Tree dead : deadTrees) {
                a[dead.y][dead.x] += dead.age / 2;
            }

            deadTrees.clear();

            for(Tree tree : trees) {
                if(tree.isDead) continue;

                if(tree.age % 5 == 0) {
                    for(int j = 0; j < 8; j++) {
                        int ny = tree.y + dy[j];
                        int nx = tree.x + dx[j];
                        if(ny <= 0 || nx <= 0 || ny > n || nx > n) continue;
                        temp.add(new Tree(1, nx, ny));
                    }
                }
            }

            trees.removeIf(tree -> tree.isDead);

            for(int y = 1; y <= n; y++) {
                for(int x = 1; x <= n; x++) {
                    a[y][x] += add[y][x];
                }
            }
        }

        trees.addAll(temp);

        bw.write(String.valueOf(trees.size()));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    private static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    private static long nextLong() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Long.parseLong(st.nextToken());
    }
}
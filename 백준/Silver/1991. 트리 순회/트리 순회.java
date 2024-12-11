import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static Node rootNode = new Node('A');
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insert(rootNode, value, left, right);
        }

        pre(rootNode);
        bw.newLine();
        mid(rootNode);
        bw.newLine();
        post(rootNode);
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }

    public static void insert(Node node, char root, char left, char right) {

        if(node.value == root) {
            node.left = left == '.' ? null : new Node(left);
            node.right = right == '.' ? null : new Node(right);
        } else {
            if (node.left != null) {
                insert(node.left, root, left, right);
            }
            if(node.right != null) {
                insert(node.right, root, left, right);
            }
        }
    }

    public static void pre(Node node) throws IOException {
        if(node == null) return;
        bw.write(node.value + "");
        pre(node.left);
        pre(node.right);
    }

    public static void mid(Node node) throws IOException {
        if(node == null) return;
        mid(node.left);
        bw.write(node.value + "");
        mid(node.right);
    }

    public static void post(Node node) throws IOException {
        if(node == null) return;
        post(node.left);
        post(node.right);
        bw.write(node.value + "");
    }
}
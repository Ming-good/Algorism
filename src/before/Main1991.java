package before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main1991 {

    static HashMap<Character, Node> map = new HashMap();
    static StringBuilder pre = new StringBuilder();
    static StringBuilder mid = new StringBuilder();
    static StringBuilder end = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            map.put(str[0].charAt(0), new Node(str[1].charAt(0), str[2].charAt(0)));
        }

        tree('A');
        System.out.println(pre.toString());
        System.out.println(mid.toString());
        System.out.println(end.toString());
    }

    private static void tree(char root) {
        if (root == '.')  return;

        Node node = map.get(root);
        if (node == null) return;

        pre.append(root);
        tree(node.left);
        mid.append(root);
        tree(node.right);
        end.append(root);
    }


    static class Node {
        char left;
        char right;

        public Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }
}

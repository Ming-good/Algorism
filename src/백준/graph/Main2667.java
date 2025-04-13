package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main2667 {

    static int map[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                char c = line.charAt(j-1);
                map[i][j] = c-'0';
            }
        }

        int groupCnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    groupCnt++;
                    visited[i][j] = true;
                    list.add(bfs(N, j, i));
                }
            }
        }
        System.out.println(groupCnt);
        Collections.sort(list);
        for (Integer in : list) {
            System.out.println(in);
        }
    }
    private static int bfs(int n,int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x,y));
        int cnt = 0;

        while (!que.isEmpty()) {
            Node node = que.poll();
            cnt++;
            if (node.y<n && map[node.y+1][node.x] == 1 && !visited[node.y+1][node.x]) {
                visited[node.y+1][node.x] = true;
                que.offer(new Node(node.x, node.y+1));
            }

            if (node.y!=0 && map[node.y-1][node.x] == 1 && !visited[node.y-1][node.x]) {
                visited[node.y-1][node.x] = true;
                que.offer(new Node(node.x, node.y-1));
            }

            if (node.x<n && map[node.y][node.x+1] == 1 && !visited[node.y][node.x+1]) {
                visited[node.y][node.x+1] = true;
                que.offer(new Node(node.x+1, node.y));
            }

            if (node.x!=0 && map[node.y][node.x-1] == 1 && !visited[node.y][node.x-1]) {
                visited[node.y][node.x-1] = true;
                que.offer(new Node(node.x-1, node.y));
            }
        }
        return cnt;
    }

    static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

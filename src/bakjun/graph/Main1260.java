package bakjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1260 {

    static boolean[][] graph;
    static boolean[] visited;
    static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int V = Integer.parseInt(str[2]);

        graph = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            String[] dot = br.readLine().split(" ");
            graph[Integer.parseInt(dot[0])][Integer.parseInt(dot[1])] = true;
            graph[Integer.parseInt(dot[1])][Integer.parseInt(dot[0])] = true;
        }
        visited = new boolean[N + 1];
        dfs(N, V);
        System.out.println(builder.toString().trim());
        builder.setLength(0);
        visited = new boolean[N + 1];
        bfs(N,V);
        System.out.println(builder.toString().trim());
    }
    private static void bfs(int n, int v) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(v);
        visited[v] = true;

        while (!que.isEmpty()) {
            Integer poll = que.poll();
            builder.append(poll).append(" ");
            for (int i = 1; i <= n; i++) {
                if (graph[poll][i] && !visited[i]) {
                    visited[i] = true;
                    que.offer(i);
                }
            }
        }
    }
    private static void dfs(int n, int v) {
        visited[v] = true;
        builder.append(v).append(" ");

        for (int i = 1; i <= n; i++) {
            if (graph[v][i] && !visited[i]) {
                dfs(n,i);
            }
        }
    }
}

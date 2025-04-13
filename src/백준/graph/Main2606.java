package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2606 {

    static boolean graph[][];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            String[] dot = br.readLine().split(" ");
            graph[Integer.parseInt(dot[0])][Integer.parseInt(dot[1])] = true;
            graph[Integer.parseInt(dot[1])][Integer.parseInt(dot[0])] = true;
        }
        visited = new boolean[N + 1];
        System.out.println(bfs(N, 1)-1);
    }
    private static int bfs(int n, int v) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(v);
        visited[v] = true;
        int cnt = 0;
        while (!que.isEmpty()) {
            Integer poll = que.poll();
            cnt++;
            for (int i = 1; i <= n; i++) {
                if (graph[poll][i] && !visited[i]) {
                    visited[i] = true;
                    que.offer(i);
                }
            }
        }

        return cnt;
    }
}

package programers.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0},
                            {1, 1, 1},
                            {0, 1, 1}};

        Network network = new Network();

        System.out.println(network.solution(3, computers));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        return BFS(n, computers);
    }

    private int BFS(int n, int[][] computers) {
        int network = 0;

        boolean[] connection = new boolean[n];
        for (int i = 0; i < n; i++) {

            if (!connection[i]) {
                network++;
            }

            Queue<Integer> que = new LinkedList<Integer>();
            que.offer(i);
            while (!que.isEmpty()) {
                Integer current = que.poll();
                connection[current] = true;

                for (int j=0; j < n; j++) {
                    if (current != j && !connection[j] && computers[current][j] == 1) {
                        que.offer(j);
                    }
                }
            }
        }

        return network;
    }

}

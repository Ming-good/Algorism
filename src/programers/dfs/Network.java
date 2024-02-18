package programers.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0},
                            {1, 1, 1},
                            {0, 1, 1}};

        Network network = new Network();

        System.out.println(network.solution(3, computers));
    }// 01

    public int solution(int n, int[][] computers) {
        int network = 0;
        boolean[] connection = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (connection[i]) {
                continue;
            }
            DFS(n, computers, i, connection);
            network++;
        }
        return network;
    }

    private void DFS(int n, int[][] computers, int depth, boolean[] connection) {
        connection[depth] = true;
        for (int i = 0; i < n; i++) {
            if (computers[depth][i] == 1 && !connection[i] && depth != i) {
                DFS(n, computers, i, connection);
            }
        }
    }

}

package programers.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class PowerGrid {

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        PowerGrid powerGrid = new PowerGrid();
        System.out.println(powerGrid.solution(n, wires));
    }
    public int solution(int n, int[][] wires) {
        int answer = 9999;
        for (int i = 0; i < wires.length; i++) {
            answer = Math.min(bfs(n, i, wires), answer);
        }
        return answer;
    }

    private int bfs(int n, int start, int[][] wires){
        int cnt = 0;
        boolean[] visit = new boolean[wires.length];
        visit[start] = true;

        Queue<Integer> que = new LinkedList<>();
        que.add(start+1);

        while (!que.isEmpty()) {
            Integer poll = que.poll();
            cnt++;

            for (int i = 0; i < wires.length; i++) {
                if(!visit[i] &&  poll == wires[i][1]) {
                    visit[i] = true;
                    que.add(wires[i][0]);
                }
                if (!visit[i] && poll == wires[i][0]) {
                    visit[i] = true;
                    que.add(wires[i][1]);
                }
            }
        }

        return Math.abs((n-cnt) - cnt);
    }
}

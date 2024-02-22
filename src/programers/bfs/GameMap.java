package programers.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class GameMap {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        GameMap gameMap = new GameMap();
        System.out.println(gameMap.solution(maps));
    }

    final int[] xArr= {1, 0, -1, 0};
    final int[] yArr= {0, 1, 0, -1};

    public int solution(int[][] maps) {
        return BFS(maps);
    }

    private int BFS(int[][] maps) {
        boolean[][] isVisit = new boolean[maps.length][maps[0].length];
        Queue<Node> que = new LinkedList<Node>();
        que.offer(new Node(0,0, 1));

        while (!que.isEmpty()) {
            Node node = que.poll();

            if (node.y == maps.length - 1 && node.x == maps[0].length - 1) {
                return node.depth;
            }

            for (int i = 0; i < 4; i++) {
                int yTemp = node.y + yArr[i];
                int xTemp = node.x + xArr[i];
                if (yTemp >= 0 && yTemp < maps.length && xTemp >= 0 && xTemp < maps[0].length && !isVisit[yTemp][xTemp] && maps[yTemp][xTemp] == 1) {
                    isVisit[yTemp][xTemp] = true;
                    que.add(new Node(yTemp, xTemp, node.depth+1));
                }
            }
        }
        return -1;
    }

    static class Node{
        int y = 0;
        int x = 0;
        int depth = 1;

        public Node(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}

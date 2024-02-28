package programers.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class GetItem {

    public static void main(String[] args) {
        GetItem getItem = new GetItem();
        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        System.out.println(getItem.solution(rectangle, 1, 3, 7, 8));
    }

    final int[] xArr= {1, 0, -1, 0};
    final int[] yArr= {0, 1, 0, -1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[] character = {characterX, characterY};
        int[] item = {itemX, itemY};

        return BFS(rectangle, character, item)/2;
    }

    private int BFS(int[][] rectangle, int[] character, int[] item) {
        boolean[][] visit = new boolean[101][101];
        character[0] = character[0]*2;
        character[1] = character[1]*2;
        item[0] = item[0]*2;
        item[1] = item[1]*2;

        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        for (int i = 0; i < rectangle.length; i++) {
            int minX = rectangle[i][0]*2;
            int minY = rectangle[i][1]*2;
            int maxX = rectangle[i][2]*2;
            int maxY = rectangle[i][3]*2;
            if ((minX <= character[0] && minY <= character[1] && maxX >= character[0] && maxY >= character[1]) &&
                    (minX == character[0] || minY == character[1] || maxX == character[0] || maxY == character[1])) {
                queue.offer(new Coordinate(character[0], character[1], 0));
                visit[character[0]][character[1]] = true;
                break;
            }
        }

        while (!queue.isEmpty()) {
            Coordinate xy = queue.poll();
            if (item[0] == xy.x && item[1] == xy.y) {
                return xy.depth;
            }

            for (int i = 0; i < rectangle.length; i++) {
                int minX = rectangle[i][0]*2;
                int minY = rectangle[i][1]*2;
                int maxX = rectangle[i][2]*2;
                int maxY = rectangle[i][3]*2;

                for (int z = 0; z < 4; z++) {
                    int x = xy.x + xArr[z];
                    int y = xy.y + yArr[z];
                    END : for (int q = 0; q < rectangle.length; q++) {
                        int nextMinX = rectangle[q][0]*2;
                        int nextMinY = rectangle[q][1]*2;
                        int nextMaxX = rectangle[q][2]*2;
                        int nextMaxY = rectangle[q][3]*2;
                        if (q == i) {
                            continue;
                        }
                        if (nextMinX < x && nextMaxX > x && nextMinY < y && nextMaxY > y) {
                            visit[x][y] = true;
                            break;
                        }
                    }
                    if ((minX <= x && minY <= y && maxX >= x && maxY >= y) &&
                            (minX == x || minY == y || maxX == x || maxY == y) &&
                            !visit[x][y]) {
                        visit[x][y] = true;
                        queue.offer(new Coordinate(x, y, xy.depth + 1));
                    }
                }

            }
        }
        return 0;
    }

    static class Coordinate{
        private int x;
        private int y;
        private int depth;

        public Coordinate(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}

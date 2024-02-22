package programers.dfs;

public class GameMap {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        GameMap gameMap = new GameMap();
        System.out.println(gameMap.solution(maps));
    }

    final int[] xArr= {1, 0, -1, 0};
    final int[] yArr= {0, 1, 0, -1};

    static int min = 999;
    public int solution(int[][] maps) {
        boolean[][] isVisit = new boolean[maps.length][maps[0].length];

        DFS(maps, 0,0, isVisit, 1);
        if (min == 999) {
            return -1;
        }
        return min;
    }

    private void DFS(int[][] maps, int y,int x, boolean[][] isVist, int moving) {

        if (moving > min) {
            return;
        }

        if (y == maps.length - 1 && x == maps[0].length - 1) {
            min = Math.min(min, moving);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int yTemp = y + yArr[i];
            int xTemp = x + xArr[i];
            if (yTemp >= 0 && yTemp < maps.length && xTemp >= 0 && xTemp < maps[0].length && !isVist[yTemp][xTemp] && maps[yTemp][xTemp] == 1) {
                isVist[yTemp][xTemp] = true;
                DFS(maps, yTemp, xTemp, isVist, moving+1);
                isVist[yTemp][xTemp] = false;
            }
        }
    }
}
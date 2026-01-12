package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3109 {

    private static char[][] map;
    private static final int[] mv = {-1,0,1};
    private static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapSizeTokken = br.readLine().split(" ");
        int r = Integer.parseInt(mapSizeTokken[0]);
        int c = Integer.parseInt(mapSizeTokken[1]);
        boolean isVisit[][] = new boolean[r][c];
        map = new char[r][c];

        for (int i=0;i<r;i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0;i<r;i++) {
            isVisit[i][0] = true;
            dfs(isVisit, i, 0, r-1,c-1);
        }

        System.out.println(cnt);
    }

    private static int dfs(boolean[][] isVisit, int r, int c, int endy, int endx) {
        if(c == endx) {
            cnt++;
            return 1;
        }

        for (int i=0;i<3;i++) {
            int y = r+mv[i];
            int x = c+1;

            if (y<0 || y> endy|| x<0 || x>endx) {
                continue;
            }

            if (!isVisit[y][x] && map[y][x] == '.') {
                isVisit[y][x] = true;
                if (dfs(isVisit, y, x, endy, endx) > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }
}

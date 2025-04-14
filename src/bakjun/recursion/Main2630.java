package bakjun.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2630 {
    private static int[][] map;
    private static int oneCnt=0;
    private static int zeroCnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        splitPage(N,0,0);

        System.out.println(zeroCnt);
        System.out.println(oneCnt);
    }

    private static void splitPage(int N,int x, int y) {
        int color = map[y][x];
        boolean isSame = true;
        for (int i = y; i < y+N; i++) {
            for (int j = x; j < x+N; j++) {
                if (color != map[i][j]) {
                    isSame = false;
                }
            }
        }

        if (isSame) {
            if (color == 1)oneCnt++;
            else zeroCnt++;
            return;
        }

        N = N / 2;
        splitPage(N, x, y);
        splitPage(N,x+N, y);
        splitPage(N,x,y+N);
        splitPage(N,x+N,y+N);
    }
}

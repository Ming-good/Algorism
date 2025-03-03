package before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2447 {

    private static char[][] ch;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ch = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(ch[i], ' ');
        }
        writeStart(N,0,0);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                builder.append(ch[i][j]);
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }

    private static void writeStart(int K, int x, int y) {
        if (K == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!(i == 1 && j == 1)) {
                        ch[x + i][y + j] = '*';
                    }
                }
            }
            return;
        }

        int size = K / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    writeStart(size,x+i*size,y+j*size);
                }
            }
        }
    }
}

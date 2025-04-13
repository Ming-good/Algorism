package 백준.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1080 {

    static int[][] A;
    static int[][] B;
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");

        int n = Integer.parseInt(token[0]);
        int m = Integer.parseInt(token[1]);

        A = new int[n][m];
        B = new int[n][m];

        for (int i=0; i<n;i++) {
            String line = br.readLine();
            for(int j=0;j<m;j++) {
                A[i][j] = line.charAt(j)-48;
            }
        }

        for (int i=0; i<n;i++) {
            String line = br.readLine();
            for(int j=0;j<m;j++) {
                B[i][j] = line.charAt(j)-48;
            }
        }

        if (n < 3 || m < 3) {
            for (int i=0; i<n;i++) {
                for(int j=0;j<m;j++) {
                    if(A[i][j] != B[i][j]) {System.out.println(-1); return;}
                }
            }
            System.out.println(0);
            return;
        }

        for (int i=0; i<=n-3;i++) {
            for(int j=0;j<=m-3;j++) {
                if(A[i][j] != B[i][j]) {
                    flip(i,j);
                }
            }
        }

        for (int i=0; i<n;i++) {
            for(int j=0;j<m;j++) {
                if(A[i][j] != B[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);
    }

    private static void flip(int y, int x) {
        cnt++;
        for (int i=0; i<3;i++) {
            for(int j=0;j<3;j++) {
                A[y+i][x+j] = 1-A[y+i][x+j];
            }
        }
    }
}

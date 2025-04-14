package bakjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int j=0;j<n;j++) {
            int caseCnt = Integer.parseInt(br.readLine());
            int[][] grade = new int[caseCnt][2];
            for (int i = 0; i < caseCnt; i++) {
                String[] str = br.readLine().split(" ");
                grade[i][0] = Integer.parseInt(str[0]);
                grade[i][1] = Integer.parseInt(str[1]);
            }

            Arrays.sort(grade, (a, b) -> Integer.compare(a[0], b[0]));

            int count = 1;
            int bestInterviewScore = grade[0][1];
            for (int i = 1; i < caseCnt; i++) {
                if(grade[i][1] < bestInterviewScore) {
                    bestInterviewScore = grade[i][1];
                    count++;
                }
            }

            System.out.println(count);
        }
    }


}

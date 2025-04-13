package 백준.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2212 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        String[] token = br.readLine().split(" ");
        int[] sensor= new int[n];
        for(int i=0;i<n;i++) {
            sensor[i] = Integer.parseInt(token[i]);
        }

        Arrays.sort(sensor);

        int[] interver = new int[n-1];
        for(int i=1;i<n;i++) {
            interver[i-1] = sensor[i] - sensor[i-1];
        }

        Arrays.sort(interver);

        int sum = 0;
        for(int i=0;i<interver.length-(k-1);i++) {
            sum += interver[i];
        }

        System.out.println(sum);

    }
}

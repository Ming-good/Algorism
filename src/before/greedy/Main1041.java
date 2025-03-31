package before.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1041 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] token = br.readLine().split(" ");
        int[] nums = new int[6];

        Arrays.sort(nums);

        int n1 = (n - 2) * (n - 2) * 5 + (n - 2) * 4;
        int n2 = 8*n-12;
        int n3 = 4;

    }
}

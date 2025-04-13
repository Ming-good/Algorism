package 백준.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main13164 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] pepleToken = br.readLine().split(" ");
        int n = Integer.parseInt(pepleToken[0]);
        int k = Integer.parseInt(pepleToken[1]);

        String[] height = br.readLine().split(" ");
        int[] heightInterver = new int[n-1];

        if(k<=1) {
            System.out.println(Integer.parseInt(height[n-1])-Integer.parseInt(height[0]));
            return;
        }

        for(int i=1;i<n;i++) {
            heightInterver[i-1] = Integer.parseInt(height[i]) - Integer.parseInt(height[i-1]);
        }

        Arrays.sort(heightInterver);

        // 간격의 최소 합을 구하는 문제임 으로 총 간격 n-1 에서 잘라낸 간격 k-1를 빼는 작업을 한다.
        int sum = 0;
        for(int i=0;i<n-k;i++) {
            sum+=heightInterver[i];
        }

        System.out.println(sum);
    }
}

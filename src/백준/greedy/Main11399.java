package 백준.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11399 {

    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] pStr = br.readLine().split(" ");

        int[] pArr = new int[N];

        for(int i=0;i<pStr.length;i++){
            pArr[i] = Integer.parseInt(pStr[i]);
        }

        Arrays.sort(pArr);

        System.out.println(recursion(0, pArr));


    }

    private static int recursion(int depth, int[] pArr) {
        if(depth == pArr.length) {
            return 0;
        }

        int sumTime = 0;
        for (int i=0; i<=depth;i++) {
            sumTime += pArr[i];
        }

        return recursion(depth+1, pArr) + sumTime;
    }
}

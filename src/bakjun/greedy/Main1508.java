package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1508 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stOption = new StringTokenizer(br.readLine());
        StringTokenizer stArr = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stOption.nextToken());
        int m = Integer.parseInt(stOption.nextToken());
        int k = Integer.parseInt(stOption.nextToken());

        int[] location = new int[k];
        for (int i=0;i<k;i++) {
            location[i] = Integer.parseInt(stArr.nextToken());
        }

        int left = 0;
        int right = n;
        int optValu = 0;
        while(left <= right) {
            int mid = (left + right)/2;
            if(getOptVal(location, mid, m)) {
                optValu = mid;
                left = mid+1;
                continue;
            }

            right = mid-1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1");
        int cnt = 1;
        int lastPos = location[0];
        for (int i = 1; i < k; i++) {
            if (location[i] - lastPos >= optValu && cnt < m) {
                sb.append("1");
                cnt++;
                lastPos = location[i];
                continue;
            }
            sb.append("0");
        }

        System.out.println(sb);
    }

    private static boolean getOptVal(int[] location, int mid, int m) {
        int cnt = 1;
        int lastPos = location[0];
        for (int i = 1; i < location.length; i++) {
            if(location[i] - lastPos >= mid) {
                cnt++;
                lastPos = location[i];
            }
        }
        return cnt>=m;
    }
}

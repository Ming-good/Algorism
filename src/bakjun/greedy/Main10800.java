package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main10800 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Ball[] ball = new Ball[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int color = Integer.parseInt(input[0]);
            int size = Integer.parseInt(input[1]);
            ball[i] = new Ball(i, color, size);
        }

        Arrays.sort(ball, (a, b) -> {
            if (a.size == b.size) return Integer.compare(a.color, b.color);
            return Integer.compare(a.size, b.size);
        });

        int totalnum = 0;
        int[] colorSum = new int[n+1];
        int[] points = new int[n];

        int j=0;
        for (int i=0;i<n;i++) {
            while(j<n && ball[j].size < ball[i].size) {
                totalnum+=ball[j].size;
                colorSum[ball[j].color] += ball[j].size;
                j++;
            }

            points[ball[i].id] = totalnum - colorSum[ball[i].color];
        }

        Arrays.stream(points).forEach(System.out::println);
    }

    static class Ball {
        public int id;
        public int color;
        public int size;

        public Ball(int id, int color, int size) {
            this.id = id;
            this.color = color;
            this.size = size;
        }
    }

}

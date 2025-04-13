package 백준.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
public class Main11000 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] classTimes = new int[n][2];
        for(int i=0;i<n;i++) {
            String[] token = br.readLine().split(" ");
            classTimes[i][0] = Integer.parseInt(token[0]);
            classTimes[i][1] = Integer.parseInt(token[1]);
        }

        Arrays.sort(classTimes, (a,b) -> a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> que = new PriorityQueue();
        que.add(classTimes[0][1]);
        for(int i=1;i<n;i++) {
            if(que.peek()<=classTimes[i][0]) {
                que.poll();
            }
            que.add(classTimes[i][1]);
        }

        System.out.println(que.size());
    }
}

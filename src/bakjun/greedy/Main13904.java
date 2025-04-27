package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main13904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] listArr = new ArrayList[1001];
        for (int i = 0; i < n; i++) {
            String[] token = br.readLine().split(" ");
            if (listArr[Integer.parseInt(token[0])] == null) {
                listArr[Integer.parseInt(token[0])] =new ArrayList<>();
            }
            listArr[Integer.parseInt(token[0])].add(Integer.parseInt(token[1]));
        }

        int sum = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=listArr.length-1;i>=1;i--) {
            if (listArr[i] != null) {
                for (int z = 0; z < listArr[i].size(); z++) {
                    que.offer(listArr[i].get(z));
                }
            }

            if (!que.isEmpty()) {
                sum += que.poll();
            }
        }

        System.out.println(sum);
    }
}

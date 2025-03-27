package before.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQue = new PriorityQueue<Integer>();

        for(int i=0;i<n;i++) {
            pQue.add(Integer.parseInt(br.readLine()));
        }

        int compareSum = 0;
        while(pQue.size() >= 2) {

            int sum = pQue.poll()+pQue.poll();
            compareSum += sum;
            pQue.add(sum);
        }

        System.out.println(compareSum);

    }

}

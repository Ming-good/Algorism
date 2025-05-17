package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main2831 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minusMan = new PriorityQueue<>();
        PriorityQueue<Integer> plusMan = new PriorityQueue<>();

        PriorityQueue<Integer> minusGirl = new PriorityQueue<>();
        PriorityQueue<Integer> plusGirl = new PriorityQueue<>();



        String[] mans = br.readLine().split(" ");
        String[] girls = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int manInt = Integer.parseInt(mans[i]);
            int girlInt = Integer.parseInt(girls[i]);
            if (manInt < 0) {
                minusMan.offer(-1 * manInt);
            }else {
                plusMan.offer(manInt);
            }

            if (girlInt < 0) {
                minusGirl.offer(-1 * girlInt);
            } else{
                plusGirl.offer(girlInt);
            }
        }
        int cupleCnt = 0;
        while (!minusGirl.isEmpty() && !plusMan.isEmpty()) {
            if (plusMan.peek() < minusGirl.peek()) {
                plusMan.poll(); minusGirl.poll();
                cupleCnt++;
                continue;
            }
            minusGirl.poll();
        }

        while (!minusMan.isEmpty() && !plusGirl.isEmpty()) {
            if (plusGirl.peek() < minusMan.peek()) {
                plusGirl.poll(); minusMan.poll();
                cupleCnt++;
                continue;
            }
            minusMan.poll();
        }

        System.out.println(cupleCnt);
    }
}

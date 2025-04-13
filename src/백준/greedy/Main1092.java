package 백준.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
public class Main1092 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] craneToken = br.readLine().split(" ");
        int k = Integer.parseInt(br.readLine());
        String[] boxToken = br.readLine().split(" ");

        Integer[] cranes = new Integer[n];
        for (int i = 0; i < n; i++) {
            cranes[i] = Integer.parseInt(craneToken[i]);
        }
        Integer[] boxes = new Integer[k];
        for (int i = 0; i < k; i++) {
            boxes[i] = Integer.parseInt(boxToken[i]);
        }

        Arrays.sort(cranes, Collections.reverseOrder());
        Arrays.sort(boxes, Collections.reverseOrder());

        if(cranes[0]<boxes[0]) {
            System.out.println(-1);
            return;
        }


        int time = 0;
        int count = 0;
        int[] positions = new int[n];
        boolean[] moved = new boolean[k];

        while(count<k) {
            for(int i=0;i<n;i++) {
                while(positions[i]<k) {
                    if(!moved[positions[i]]&&boxes[positions[i]]<=cranes[i]) {
                        moved[positions[i]] = true;
                        positions[i]++;
                        count++;
                        break;
                    }
                    positions[i]++;
                }
            }
            time++;
        }

        System.out.println(time);

    }
}

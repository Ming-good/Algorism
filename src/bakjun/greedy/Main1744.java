package bakjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main1744 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> positives = new ArrayList<>(); // 1보다 큰 양수
        ArrayList<Integer> negatives = new ArrayList<>(); // 0과 음수
        int sum = 0;
        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());
            if(num>1) {
                positives.add(num);
            } else if(num==1) {
                sum += 1;
            } else {
                negatives.add(num);
            }
        }

        Collections.sort(positives, Collections.reverseOrder());
        for(int i=0;i<positives.size();i++) {
            if (i + 1 < positives.size()) {
                sum += positives.get(i) * positives.get(i + 1);
                i++;
                continue;
            }
            sum += positives.get(i);
        }

        Collections.sort(negatives);
        for(int i=0;i<negatives.size();i++) {
            if (i + 1 < negatives.size()) {
                sum += negatives.get(i) * negatives.get(i + 1);
                i++;
                continue;
            }
            sum += negatives.get(i);
        }

        System.out.println(sum);
    }
}

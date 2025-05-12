package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1461_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokken = br.readLine().split(" ");
        int n = Integer.parseInt(tokken[0]);
        int m = Integer.parseInt(tokken[1]);

        String[] bookTokken = br.readLine().split(" ");
        List<Integer> minusList = new ArrayList();
        List<Integer> plusList = new ArrayList<>();
        int sumDistance = 0;
        for (String book : bookTokken) {
            int num = Integer.parseInt(book);
            if (num < 0) {
                minusList.add(num*-1);
                continue;
            }
            plusList.add(num);
        }

        if (minusList.isEmpty()) minusList.add(0);
        if (plusList.isEmpty()) plusList.add(0);

        Collections.sort(minusList, Collections.reverseOrder());
        Collections.sort(plusList, Collections.reverseOrder());
        for (int i = 0; i < minusList.size();i++) {
            sumDistance += minusList.get(i)*2;
            i += m - 1;
        }// 39 37 29 28 6 0 2 11

        for (int i = 0; i < plusList.size();i++) {
            sumDistance += plusList.get(i)*2;
            i += m - 1;
        }
        sumDistance -= Math.max(minusList.get(0), plusList.get(0));
        System.out.println(sumDistance);
    }

}

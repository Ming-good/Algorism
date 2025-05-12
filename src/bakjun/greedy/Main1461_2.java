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

        String[] bookToken = br.readLine().split(" ");
        List<Integer> minusList = new ArrayList();
        List<Integer> plusList = new ArrayList<>();
        int totalDistance = 0;
        for (String book : bookToken) {
            int num = Integer.parseInt(book);
            if (num < 0) {
                minusList.add(num*-1);
                continue;
            }
            plusList.add(num);
        }

        Collections.sort(minusList, Collections.reverseOrder());
        Collections.sort(plusList, Collections.reverseOrder());

        totalDistance += calcuateDistance(minusList, m);
        totalDistance += calcuateDistance(plusList, m);

        int maxDist = 0;
        if (!minusList.isEmpty()) maxDist = Math.max(maxDist, minusList.get(0));
        if (!plusList.isEmpty()) maxDist = Math.max(maxDist, plusList.get(0));
        totalDistance -= maxDist;

        System.out.println(totalDistance);
    }

    private static int calcuateDistance(List<Integer> list, int m) {
        int distance=0;
        for (int i = 0; i < list.size();i+=m) {
            distance += list.get(i)*2;
        }
        return distance;
    }
}

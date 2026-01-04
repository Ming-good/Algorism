package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2036_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Long> plusList = new ArrayList<>();
        List<Long> minusList = new ArrayList<>();

        for (int i=0;i<n;i++) {
            long num = Long.parseLong(br.readLine());
            if (num >0) {
                plusList.add(num);
            } else {
                minusList.add(num);
            }
        }
        plusList.sort((o1, o2) -> o2.compareTo(o1));
        minusList.sort(Long::compareTo);

        long sum = 0;
        for (int i=0;i<plusList.size();i++) {
            long a,b = 0;
            a = plusList.get(i);
            if (plusList.size()>i+1) {
                b = plusList.get(i + 1);
                i++;
            }

            if (a > 1 && b > 1) {
                sum += a*b;
                continue;
            }
            sum += a+b;
        }

        for (int i=0;i<minusList.size();i++) {
            long a,b = 0;
            if (minusList.size()>i+1) {
                a = minusList.get(i);
                b = minusList.get(i + 1);
                i++;
                sum += a*b;
                continue;
            }

            a = minusList.get(i);
            sum += a;
        }

        System.out.println(sum);
    }
}

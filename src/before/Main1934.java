package before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1934 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine().split(" "));
        }

        for (int i = 0; i < n; i++) {
            int a = Math.max(Integer.parseInt(list.get(i)[0]), Integer.parseInt(list.get(i)[1]));
            int b = Math.min(Integer.parseInt(list.get(i)[0]), Integer.parseInt(list.get(i)[1]));

            System.out.println(a*b/gcd(a,b));
        }
    }

    public static int gcd(int a, int b) {
        int tmp;
        while (b!=0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}


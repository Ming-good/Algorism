package before.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2156 {

    static long[] f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        f = new long[length + 1];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        f[1] = list.get(0);
        if (length == 1) {
            System.out.println(f[length]);
            return;
        }
        f[2] = f[1] + list.get(1);
        if (length == 2) {
            System.out.println(f[length]);
            return;
        }
        f[3] = Math.max(Math.max(f[2], f[1] + list.get(2)), list.get(1) + list.get(2));
        if (length == 3) {
            System.out.println(f[length]);
            return;
        }

        for (int i = 4; i <= length; i++) {
            f[i] = Math.max(f[i-1], Math.max(f[i-2]+list.get(i-1), f[i-3] + list.get(i-1) + list.get(i-2)));
        }
        System.out.println(f[length]);
    }
}

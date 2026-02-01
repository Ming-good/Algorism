package bakjun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
/*
* https://www.acmicpc.net/status?user_id=read1516&problem_id=10815&from_mine=1
* 10815번 문제
* */
public class Main10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] card = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");

        HashSet<String> set = new HashSet<>();
        set.addAll(List.of(card));

        for (int i=0; i<m; i++) {
            if (set.contains(num[i])) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }

            if (i == m-1) {
                break;
            }
            System.out.print(" ");
        }
    }

}

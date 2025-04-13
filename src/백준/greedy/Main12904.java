package 백준.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/12904
public class Main12904 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        StringBuilder builder = new StringBuilder(T);

        while(S.length()<builder.length()) {
            char ch = builder.charAt(builder.length()-1);
            builder.deleteCharAt(builder.length()-1);
            if(ch == 'B') {
                builder.reverse();
            }
        }

        if (S.equals(builder.toString())) {
            System.out.println("1");
            return;
        }

        System.out.println("0");
    }
}

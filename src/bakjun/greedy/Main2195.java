package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2195 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();

        StringBuilder sbr = new StringBuilder();

        int cnt = 0;
        for (int i = 0; i < P.length(); i++) {
            for (int j = i; j < P.length(); j++) {
                sbr.append(P.charAt(j));
                if (S.indexOf(sbr.toString()) < 0) {
                    cnt++;
                    if (j == P.length() - 1) {
                        break;
                    }
                    i = j - 1;
                    break;
                }
            }
            sbr.setLength(0);
        }
        System.out.println(cnt+1);
    }

}
package bakjun.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();

        String org = br.readLine();
        String boom = br.readLine();

        for (int i = 0; i < org.length(); i++) {
            builder.append(org.charAt(i));
            if (builder.length() >=boom.length() && builder.substring(builder.length()-boom.length()).equals(boom)) {
                builder.setLength(builder.length()-boom.length());
            }
        }

        if (builder.length() == 0) {
            System.out.println("FRULA");
            return;
        }

        System.out.println(builder);
    }
}

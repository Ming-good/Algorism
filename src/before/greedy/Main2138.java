package before.greedy;

import java.io.*;
import java.util.*;

public class Main2138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String from = br.readLine();
        String to = br.readLine();

        StringBuilder builder = new StringBuilder();
        for(int i=1;i<from.length();i++) {
            Integer fromCh1 = from.charAt(i-1)-48;
            Integer toCh1 = to.charAt(i-1)-48;
            if(fromCh1 == toCh1) {
                builder.append(fromCh1);
                continue;
            }

            for(int j=-1;j<2&&i+j<from.length();j++) {
                Integer light = from.charAt(i+j)-48;
                if(builder.length()>=i+j+1) {
                    builder.deleteCharAt(i+j);
                    continue;
                }
                builder.append(1-light);
            }
        }

        System.out.println(builder);

        builder.setLength(0);
        for(int i=1;i<from.length();i++) {
            Integer fromCh1 = from.charAt(i-1)-48;
            Integer toCh1 = to.charAt(i-1)-48;
            if(fromCh1 == toCh1) {
                builder.append(fromCh1);
                continue;
            }


            for(int j=-1;j<2&&i+j<from.length();j++) {
                if(i==1 && j==1) {
                    break;
                }

                Integer light = from.charAt(i+j)-48;
                if(builder.length()>=i+j+1) {
                    builder.deleteCharAt(i+j);
                    continue;
                }
                builder.append(1-light);
            }
        }


        System.out.println(builder);
    }
}

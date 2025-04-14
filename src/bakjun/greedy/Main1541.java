package bakjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int a = 0;
        int b= 0;
        int minusFlug = 0;
        int startIndex = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '+' && minusFlug == 0) {
                a+=Integer.parseInt(str.substring(startIndex, i));
                startIndex = i+1;
                continue;
            }

            if(str.charAt(i) == '-' && minusFlug == 0) {
                a+=Integer.parseInt(str.substring(startIndex, i));
                startIndex = i+1;
                minusFlug = 1;
            } else if ((str.charAt(i) == '-' || str.charAt(i) == '+') && minusFlug == 1){
                b+=Integer.parseInt(str.substring(startIndex, i));
                startIndex = i+1;
            }

            if (i==str.length()-1 && minusFlug==1) {
                b+=Integer.parseInt(str.substring(startIndex));
            } else if (i==str.length()-1 && minusFlug==0) {
                a+=Integer.parseInt(str.substring(startIndex));
            }
         }

        System.out.println(a - b);
    }
}

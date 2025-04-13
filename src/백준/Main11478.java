package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
* https://www.acmicpc.net/problem/11478
* 11478번 문제
* */
public class Main11478 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Set set = new HashSet();

        for (int i = 1; i <= str.length(); i++) {
            for (int z = 0; z < str.length()-(i-1); z++) {
                set.add(str.substring(z, z + i));
            }
        }
        System.out.println(set.size());
    }
}

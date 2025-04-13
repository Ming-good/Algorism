package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main24511 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] isQue = br.readLine().split(" ");
        String[] str = br.readLine().split(" ");


        int N = Integer.parseInt(br.readLine());
        String[] insertNum = br.readLine().split(" ");
        Queue<String> que = new LinkedList<>();
        for (int i=size-1;i>-1;i--) {
            if (Integer.parseInt(isQue[i]) == 0) {
                que.add(str[i]);
            }
        }

        StringBuilder bilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            que.add(insertNum[i]);
            bilder.append(que.poll() + " ");
        }

        System.out.print(bilder.toString().trim());
    }
}

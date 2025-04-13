package 백준.dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
*  문제번호 1463번
*  1로 만들기
*  URL : https://www.acmicpc.net/problem/1463
* */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Main oneMake = new Main();
        System.out.println(oneMake.solution(N));
    }

    public int solution(int N) {
        if(N == 1)
            return 0;

        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(N, 0));

        boolean[] visit = new boolean[N+1];
        visit[N] = true;

        while (!que.isEmpty()) {
            Node node = que.poll();

            if (node.N == 1) {
                return node.cnt;
            }

            if (node.N % 3 == 0  && !visit[node.N/3]) {
                que.offer(new Node(node.N/3, node.cnt+1));
                visit[node.N / 3] = true;
            }

            if (node.N % 2 == 0 && !visit[node.N/2]) {
                que.offer(new Node(node.N/2, node.cnt+1));
                visit[node.N / 2] = true;
            }

            if (node.N > 1 && !visit[node.N - 1]) {
                que.offer(new Node(node.N-1, node.cnt+1));
                visit[node.N - 1] = true;
            }
        }
        return 0;
    }


    static class Node {

        public Node(int n, int cnt) {
            N = n;
            this.cnt = cnt;
        }

        int N;
        int cnt=0;
    }
}

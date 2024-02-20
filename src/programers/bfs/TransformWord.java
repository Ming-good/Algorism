package programers.bfs;

import java.util.LinkedList;
import java.util.Queue;

// DFS로 성공적으로 품 2024.02.19
public class TransformWord {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};


        TransformWord transformWord = new TransformWord();
        System.out.println(transformWord.solution(begin, target, words));
    }
    public int solution(String begin, String target, String[] words) {
        boolean noTarget = false;
        for (String str : words) {
            if (target.equals(str)) {
                noTarget = false;
                break;
            }
            noTarget = true;
        }

        if (noTarget) {
            return 0;
        }
        return BFS(begin,target,words);
    }

    private int BFS(String begin, String target, String[] words) {
        Node node = new Node(begin, 0);
        boolean[] visit = new boolean[words.length];
        Queue<Node> que = new LinkedList<Node>();
        que.offer(node);

        while (!que.isEmpty()) {
            int size = que.size();
            node = que.poll();
            if (node.word.equals(target)) {
                break;
            }
            for (int i = 0; i < words.length; i++) {
                if (checkTranform(node.word, words[i]) != 1 || visit[i]) {
                    continue;
                }
                que.offer(new Node(words[i], node.depth + 1));
                visit[i] = true;
            }
        }
        return node.depth;
    }

    private int checkTranform(String begin, String words) {
        int cnt = 0;
        for (int i=0;i<words.length();i++) {
            if (begin.charAt(i) != words.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    static class Node{
        String word;
        int depth;
        public Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}

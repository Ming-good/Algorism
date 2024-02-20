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
        int cnt = -1;

        boolean[] visit = new boolean[words.length];
        Queue<String> que = new LinkedList<String>();
        que.offer(begin);

        while (!que.isEmpty()) {
            cnt++;
            int size = que.size();
            for (int z = 0; z < size; z++ ) {
                String word = que.poll();
                if (word.equals(target)) {
                    break;
                }
                for (int i = 0; i < words.length; i++) {
                    if (checkTranform(word, words[i]) != 1 || visit[i]) {
                        continue;
                    }
                    que.offer(words[i]);
                    visit[i] = true;
                }
            }
        }

        return cnt;
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
}

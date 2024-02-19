package programers.dfs.transformWord;

// DFS로 성공적으로 품 2024.02.19
public class TransformWordV2 {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};


        TransformWordV2 transformWord = new TransformWordV2();
        System.out.println(transformWord.solution(begin, target, words));
    }
    static int min = 999;
    public int solution(String begin, String target, String[] words) {
        boolean[] visit = new boolean[words.length];
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
        DFS(begin, target, words, visit,0);
        return min;
    }

    private void DFS(String begin, String target, String[] words, boolean[] visit ,int depth) {
        if (begin.equals(target)) {
            min = Math.min(min, depth);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(begin)) {
                visit[i] = true;
                continue;
            }
            if (checkTranform(begin, words[i]) > 1 || visit[i]) {
                continue;
            }

            visit[i] = true;
            DFS(words[i], target, words, visit, depth+1);
            visit[i] = false;
        }
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

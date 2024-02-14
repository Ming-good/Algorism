package programers.dfs;

import java.util.Arrays;

public class TargetNumber {
    private static int answer = 0;

    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0);
        return answer;
    }

    private static void DFS(int[] numbers, int target, int i) {
        if (i == numbers.length) {
            if (Arrays.stream(numbers).sum() == target) answer += 1;
            return;
        }

        DFS(numbers, target, i+1);
        numbers[i] = numbers[i]*(-1);
        DFS(numbers, target, i+1);
    }
}

package programers.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maths {
    public static void main(String[] args) {

        int[] answer = {1,3,2,4,2};
        Maths math = new Maths();
        int[] solution = math.solution(answer);
        Arrays.stream(solution).forEach(e -> System.out.println(e));
    }

    int[] num1 = {1,2,3,4,5};
    int[] num2 = {2,1,2,3,2,4,2,5};
    int[] num3 = {3,3,1,1,2,2,4,4,5,5};

    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] gb = {0,0,0};

        for (int i = 0; i < answers.length; i++) {
            gb[0] += checkNum(answers[i], num1[i%num1.length]);
            gb[1] += checkNum(answers[i], num2[i%num2.length]);
            gb[2] += checkNum(answers[i], num3[i%num3.length]);
        }

        int max = Math.max(gb[0],Math.max(gb[1], gb[2]));

        for (int i = 0; i<3; i++) {
            if (max == gb[i]) {
                list.add(i+1);
            }
        }

        return list.stream().sorted().mapToInt(i-> i).toArray();
    }

    private int checkNum(int a, int b) {
        if(a == b)
            return 1;
        return 0;
    }
}
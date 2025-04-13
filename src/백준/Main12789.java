package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main12789 {
    private static int curN = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Integer> stack = new Stack<>();

        for (int number : arr) {
            if (number == curN) {
                curN++;
                continue;
            } else if(!stack.isEmpty()){
                checkStack(stack);
            }
            stack.push(number);
        }
        checkStack(stack);
        if (stack.size() == 0) {
            System.out.print("Nice");
            return;
        }

        System.out.print("Sad");
    }

    private static void checkStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            if (curN != stack.peek()) {
                return;
            }

            stack.pop();
            curN++;
        }
    }
}

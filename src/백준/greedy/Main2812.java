package 백준.greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main2812 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int n = Integer.parseInt(token[0]);
        int k = Integer.parseInt(token[1]);
        String number  = br.readLine();
        int removed = 0;
        Stack<Character> stack = new Stack();
        for(int i=0;i<n;i++) {
            char ch = number.charAt(i);
            while(!stack.isEmpty() && stack.peek()<ch && removed<k) {
                stack.pop();
                removed++;
            }
            stack.add(ch);
        }

        while(removed < k) {
            stack.pop();
            removed++;
        }

        StringBuilder builder = new StringBuilder();
        for(char ch : stack) {
            builder.append(ch);
        }

        System.out.println(builder.toString());
    }
}

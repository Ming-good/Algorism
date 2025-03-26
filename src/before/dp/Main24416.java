package before.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main24416 {

    static int[] f;
    static int callFib = 0;
    static int callFibonacci = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        f = new int[N+1];

        fib(N);
        fibonacci(N);

        System.out.println(callFib + " " + callFibonacci);
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            callFib++;
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    private static int fibonacci(int n) {
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            callFibonacci++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}

import java.util.Scanner;
/* 쉽게 문제 풀기 */

public class Main10 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();
		
		int sum = 0;
		int min = 0;
		
		boolean flag = true;

		for(int i=M;i<=N;i++) {
			if(isPrime(i)) {
				if(flag)  {
					flag = false;
					min = i;
				}
				sum += i;
			}
		}
		
		if(sum > 0) {
			System.out.println(sum);
			System.out.println(min);
			return;
		}
		
		System.out.println(-1);
		
	}
	
	private static boolean isPrime(int num) {
		
		if(num == 1 || num == 0)
			return false;
		
		for(int i=2;i*i<=num;i++) {
			if(num%i == 0)
				return false;
		}
		return true;
	}	
	
}
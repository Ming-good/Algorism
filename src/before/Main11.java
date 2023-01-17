package before;

import java.io.IOException;
import java.util.Scanner;
/* ¼Ò¼ö */

public class Main11 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();

		int min = 0;
		int sum = 0;
		
		boolean firstPrime = true;
		
		for(int i = M;i<=N;i++) {
			
			if(firstPrime && isPrime(i)) {
				min = i;
				sum += i;
				firstPrime = false;
				continue;
			}
			
			if(isPrime(i)) {
				sum += i;
			}
		}
		
		if(sum == 0) {
			System.out.println("-1");
			return;
		}
		
		
		System.out.println(sum);
		System.out.println(min);
		
	}
	
	private static boolean isPrime(int num) {
		if(num == 1 || num == 0) {
			return false;
		}
		
		for(int i = 2;i*i<=num;i++) {
			if(num%i==0)
				return false;
		}
		
		return true;
	}


}
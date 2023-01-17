package before;

import java.io.IOException;
import java.util.Scanner;
/* 소수찾기 */

public class Main8 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int cnt = 0;
		
		for(int i=0;i<n;i++) {
			int num = in.nextInt();
			if(isPrime(num)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
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
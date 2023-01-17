package before;

import java.util.Scanner;

/** 소수의 합, 최솟값 구하기 */

public class Math2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int M = in.nextInt();
		int N = in.nextInt();
		
		int sum = 0;
		int min = 0; 
		
		boolean flag = true;
		
		
		
		for(int i=M;i<=N;i++) {
			
			if(checkSosu(i, (int) Math.floor(Math.sqrt(i)))) {

				if(flag) {
					min = i;
					flag = false;
				}
				sum += i;
			}
		}
		if(sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
	
	public static boolean checkSosu(int num, int i) {
		
		if(num == 1) {
			return false;
		}
		
		if(i<2) {
			return true;
		}
		
		if(num != i && (num%i == 0)) {
			return false;
		}
		
		return checkSosu(num, --i);
	}	
}

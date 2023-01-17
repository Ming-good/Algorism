package before;

import java.util.Scanner;
/* 백준 피보나치 수열
 * 
 * */


public class Main4 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n 	= in.nextInt();
		
		Main4 main = new Main4();
		System.out.println(main.fibonacci(n));
	}
	
	public int fibonacci(int n) {
		
		
		
		if(n == 0)
			return 0;
		
		if(n==1 || n==2) 
			return 1;
		
		
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
}

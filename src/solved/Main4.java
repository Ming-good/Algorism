package solved;

import java.io.IOException;
import java.util.Scanner;

/* 숫자의 개수 */
public class Main4 {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);

		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		
		int sum = A*B*C;
		
		String strNum = String.valueOf(sum);
		
		for(int i=0;i<10;i++) {
			System.out.println(String.valueOf(count(strNum, Character.forDigit(i, 10))));
		}
	}
	
	private static long count(String num, char ch) {
		return num.chars().filter(c->c==ch).count();
	}
}

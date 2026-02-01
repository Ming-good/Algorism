package bakjun.etc;

import java.util.Scanner;
/* ���� ������ ����ö (����ö�� ž�� ���� ���� ���� �� ���� ���ϴ� ����)
 * 
 * */


public class Main3 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int sum = 0;
		int maxNum = sum;
		
		int minus = 0;
		int plus = 0;
		
		for(int i=0;i<10;i++) {
			minus 	= in.nextInt();
			plus	= in.nextInt();
			
			sum -= minus;
			sum += plus;
			
			if(maxNum < sum) {
				maxNum = sum;
			}
		}
		

		System.out.println(maxNum);
	}
	
}

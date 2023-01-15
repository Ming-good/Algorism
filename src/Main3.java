import java.util.Scanner;
/* 백준 지혜의 지하철 (지하철에 탑승 고객이 가장 많을 때 수를 구하는 문제)
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

import java.util.Scanner;
/* 쉽게 문제 풀기 */

public class Main9 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		
		int[] buffer = new int[1000];
		int value = 1;
		int cnt = 0;
		for(int i=0;i<1000;i++) {

			buffer[i] = value;
			cnt++;
			if(value == cnt) {
				value++;
				cnt = 0;
			}
		}
		
		int sum = 0;
		for(int i=a-1;i<b;i++) {
			sum += buffer[i];
		}
		
		System.out.println(sum);
		
	}
	
}
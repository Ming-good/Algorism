package 백준;

import java.io.IOException;
/* ���� �ִ����� �ּҰ���� ���� �������... ��Ŭ���� ȣ�������� �ִ������� ���ϰ� �ּҰ������ �� ���� ���ϰ� �ִ������� ������ ��.
 * 
 * */
import java.util.Scanner;


public class Main6 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner in = new Scanner(System.in);
		int n1 	= in.nextInt();
		int n2 	= in.nextInt();
		
		int max = Math.max(n1, n2);
		int min = Math.min(n1, n2);
		
		Main6 main = new Main6();
		int comnNum = main.gcd(max, min);

		System.out.println(comnNum);
		System.out.println(max*min/comnNum);
		
	}

	public int gcd(int a, int b) {
		
		if(a%b == 0) {
			return b;
		}
		
		
		return gcd(b, a%b);
	}
	
}

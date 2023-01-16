package solved;

import java.io.IOException;
import java.util.Scanner;

/* ЦђБе */
public class Main3 {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		double sum = 0;
		int max = 0;
		
		for(int i=0;i<N;i++) {
			int num = in.nextInt();
			max = Integer.max(max, num);
			sum += num;
		}
		
		if(sum == 0) {
			System.out.println(0);
			return;
		}
		
		System.out.println((sum/max*100)/N);
	}
}

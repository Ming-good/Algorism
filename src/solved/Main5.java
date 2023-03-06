package solved;

import java.io.IOException;
import java.util.Scanner;

/* ÃÖ´ñ°ª */
public class Main5 {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);

		int max = 0;
		int index = 0;
		
		for(int i=0;i<9;i++) {
			int num = in.nextInt();
		
			if(max < num) {
				max = num;
				index = i+1;
			}
		}
		
		System.out.println(max);
		System.out.println(index);
		
		
	}
}

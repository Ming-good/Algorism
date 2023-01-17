package solved;

import java.io.IOException;
import java.util.Scanner;

/* º°Âï±â */
public class Main6 {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		
		
		for(int i=0;i<N;i++) {
			for(int z=1;z<N-i;z++) {
				System.out.print(" ");
			}
			
			for(int y=0;y<i+1;y++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

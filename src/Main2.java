import java.util.Scanner;

/*
 * 백준 이진수 3460
 * */
public class Main2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		for(int z = 0;z<T;z++) {
			int N = in.nextInt();
			int i = 0;
			
			if(N==1) System.out.print(0);
			while(N != 1) {
				if(N%2 == 1) System.out.print(i + " ");
				
				N = N/2;
				i++;
				if(N == 1 && N%2 == 1) {
					System.out.print(i + " ");
				}
			}
			
			System.out.println();			
		}
	}
}

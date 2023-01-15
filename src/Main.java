import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/* 백준 약수 구하기
 * 
 * */


public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int K = in.nextInt();

		ArrayList arr = new ArrayList();
		
		for(int i=1;i<=(int)Math.floor(Math.sqrt(N));i++) {
			if(N%i == 0) {
				arr.add(i);
				if(i != N/i) {
					arr.add(N/i);
				}
				
			}
		}
		
		Collections.sort(arr);
		System.out.println(arr.toString());
		if(arr.size() < K) {
			System.out.println(0);
			return;
		}
		
		System.out.println(arr.get(K-1));
		return;
	}
	
}

package before;

import java.util.Scanner;

/** 소수를 찾아라 */
public class Math1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int chkNum = 0;
		
		int N = in.nextInt();
		int num = 0;
		
		for(int i=0;i<N;i++) {
			num = in.nextInt();
			if(checkSosu(num, (int) Math.floor(Math.sqrt(num)))) {
				chkNum++;
			}
		}
		System.out.println(chkNum);	
	}
	
	public static boolean checkSosu(int num, int i) {
		
		if(num == 1) {
			return false;
		}
		
		if(i<2) {
			return true;
		}
		
		if(num != i && (num%i == 0)) {
			return false;
		}
		
		return checkSosu(num, --i);
	}
}

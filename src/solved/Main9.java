package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* À½°è */
public class Main9 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numLine = br.readLine();
		
		String numArr[] = numLine.split(" ");

		int init = Integer.parseInt(numArr[0]);
		
		if(init == 1) {
			ascending(numArr);
			return;
		}
			
		if(init == 8) {
			descending(numArr);
			return;
		}
			
		if(init != 1 || init != 8) {
			System.out.println("mixed");
			return;
		}
			
		
	}
	
	private static void ascending(String[] str) {
		int num = 1;
		for(int i=0;i<8;i++) {
			if(Integer.parseInt(str[i]) != num++) {
				System.out.println("mixed");
				return;
			}
		}
		
		System.out.println("ascending");
	}
	
	private static void descending(String[] str) {
		int num = 8;
		for(int i=0;i<8;i++) {
			if(Integer.parseInt(str[i]) != num--) {
				System.out.println("mixed");
				return;
			}
		}
		
		System.out.println("descending");
	}	
}

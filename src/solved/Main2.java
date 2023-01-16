package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 단어 공부	*/
public class Main2 {

	private static int max 	= 0;
	private static boolean dup = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();	
		
		char ch = 0;
		for(char i='A';i<='Z';i++) {
			
			int cnt = count(str.toUpperCase(), i);
			findDup(cnt);
			
			if(cnt > max) {
				max = cnt;
				ch = i;
				dup = false;
			}
		}
		
		if(dup) {
			System.out.println("?");
			return;
		}
		
		System.out.println(ch);
	}
	
	private static int count(String str, char ch) {
		
		if(str.trim().length() == 0)
			return 0;
		
		return (int)str.trim().chars().filter(c-> c == ch).count();
	}
	
	private static void findDup(int num) {
		if(max == num)
			dup = true;
		
	}
}

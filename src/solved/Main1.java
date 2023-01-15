package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 단어의 개수	*/
public class Main1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();	
		
		System.out.println(count(str));
		
	}
	
	private static long count(String str) {
		
		if(str.trim().length() == 0)
			return 0;
		
		return str.trim().chars().filter(c-> c == ' ').count()+1;
	}
}

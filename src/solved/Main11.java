package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 숫자의 합 */
public class Main11 {

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		System.out.println(sum(str.toCharArray()));
		
		
		
	}
	
	private static int sum(char[] ch) {
		int sum = 0;
		for(char c : ch) {
			sum += Character.getNumericValue(c);
		}
		return sum;
	}
}

package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* »ó¼ö */
public class Main8 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numLine = br.readLine();
		
		String numArr[] = numLine.split(" ");

		int N = reverse(numArr[0]);
		int M = reverse(numArr[1]);
		
		System.out.println(Integer.max(N, M));
	}
	
	private static int reverse(String str) {
		StringBuffer buffer = new StringBuffer(str);
		return Integer.parseInt(buffer.reverse().toString());
	}
}

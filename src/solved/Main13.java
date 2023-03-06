package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 단어정렬 */
public class Main13 {

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String size = br.readLine();
		int length = Integer.parseInt(size);
		
		String[] str = new String[length];
		
		for(int i=0;i<length;i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}			
				
				return s1.length() - s2.length();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		 
		sb.append(str[0]).append('\n');
		
		for (int i = 1; i < length; i++) {
			// 중복되지 않는 단어만 출력
			if (!str[i].equals(str[i - 1])) {
				sb.append(str[i]).append('\n');
			}
		}
		System.out.println(sb);
		
	}
	

}

package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 문자열 반복 */
public class Main7 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuffer buffer = new StringBuffer();
		
		List<String> list = new ArrayList<String>();
		
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split(" ");
			
			for(int z=0;z<str[1].length();z++) {
				for( int y=0;y<Integer.parseInt(str[0]);y++) {
					buffer.append(str[1].charAt(z));
				}
			}
			
			list.add(buffer.toString());
			buffer.setLength(0);
		}
		
		for(String output : list) {
			System.out.println(output);
		}
		
		
	}
}

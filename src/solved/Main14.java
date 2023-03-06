package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 스택 수열 */
public class Main14 {

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int x = 1;
		
		
		StringBuilder buffer = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<size;i++) {
			int m = Integer.parseInt(br.readLine());
			
			while(m>=x) {
				stack.push(x++);
				buffer.append("+\n");
			}
			
			if(m != stack.pop()) {
				System.out.println("NO");
				return;
			}
				
			buffer.append("-\n");
		}
		
		System.out.println(buffer.toString());
		
	}
	

}

package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 단어 뒤집기2 */
public class Main15 {

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		boolean skip = false;
		
		StringBuilder buffer = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();		
		
		for(char ch : str.toCharArray()) {
			if(ch == '<') {
				skip = true;
				print(stack, buffer);
				buffer.append(ch);
				continue;
			}
			
			if(ch == '>') {
				skip = false;
				buffer.append(ch);
				continue;
			}
			
			if(!skip && ch == ' ') {
				print(stack, buffer);	
				buffer.append(" ");
				continue;
			}			
			
			if(skip) {
				buffer.append(ch);			
				continue;
			}			
			
			stack.push(ch);
		}
		
		print(stack, buffer);
		
		System.out.println(buffer.toString());
	}
	
	private static void print(Stack stack, StringBuilder buffer) {
		while(!stack.empty()) {
			buffer.append(stack.pop());
		}		
	}

}

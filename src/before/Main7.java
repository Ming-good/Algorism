package before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* N번째 큰 수 */

public class Main7 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Integer[] answer = new Integer[n];
		
		String str = "";
		for(int i=0;i<n;i++) {
			str = br.readLine();
			String[] arr = str.split(" ");
			List<Integer> numArr = stringToList(arr);
			Collections.sort(numArr);
			answer[i] = numArr.get(7);
		}
		
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
		
		
	}

	private static List stringToList(String[] arr) {
		List list = new ArrayList<Integer>();
		
		
		for(int i=0;i<arr.length;i++) {
			list.add(Integer.parseInt(arr[i]));
		}
		return list;
	}

	
}

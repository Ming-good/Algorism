package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* OXÄûÁî */
public class Main10 {

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<size;i++) {
			list.add(sumOx(br.readLine().toCharArray()));
		}
		
		for(Integer num : list) {
			System.out.println(num);
		}
		
	}
	
	private static int sumOx(char[] charArr) {
		int sum = 0;
		int cnt = 1;
		for(char ch : charArr) {
			if(ch == 'X') {
				cnt = 1;
				continue;
			}
			
			sum += cnt++;
		}
		
		return sum;		
	}
}

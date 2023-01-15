import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
/* 백준 일곱난장이
 * 
 * */


public class Main5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;

		int[] arr = new int[7];
		int[] allArr = new int[9];
		HashSet<Integer> hash = new HashSet<Integer>();
		
		for(int i=0;i<9;i++) {
			int n 	= Integer.parseInt(br.readLine());
			sum += n;
			hash.add(n);
			allArr[i] = n;
		}
		
		sum = sum-100;
		
		Main5 main = new Main5();
		main.testDwarf(sum, hash, allArr);
		
		int i=0;
		for(int num : hash) {
			arr[i++] = num;
		}
		
		Arrays.sort(arr);
		
		for(int num : arr) {
			System.out.println(num);
		}
		
	}
	
	public void testDwarf(int sum, HashSet hash, int[] arr) {
		end:for(int i=0;i<arr.length-1;i++) {
			for(int z=i+1;z<arr.length;z++) {
				if(sum == (arr[i] + arr[z])) {
					hash.remove(arr[i]);
					hash.remove(arr[z]);
					break end;
				}
			}
		}
	}
	
}

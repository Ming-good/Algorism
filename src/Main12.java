import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/* 연산자 끼워넣기 */

public class Main12 {
	private static int max = -1111111111;
	private static int min = 1111111111;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] An = br.readLine().split(" ");
		String[] operator = br.readLine().split(" ");
		
		int[] AArr = strToIntArr(An);
		int[] operatorArr = strToIntArr(operator);
		
		maxAndMin(AArr, operatorArr, 0, AArr[0]);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	private static int[] strToIntArr(String[] num) {
		int[] arr = new int[num.length]; 
		for(int i=0;i<num.length;i++) {
			arr[i] = Integer.parseInt(num[i]);
		}
		return arr;
	}	
	
	private static void maxAndMin(int[] aArr, int[] operArr, int depth, int sum) {
		int tmp = 0;
		if(depth == aArr.length-1) {
			updateMaxAndMin(sum);
			return;
		}
		
		for(int i=0;i<operArr.length;i++) {
			
			if(operArr[i] == 0) 
				continue;
			
			operArr[i] = operArr[i]-1;
			tmp = sum;
			switch (i) {
				case 0 : sum += aArr[depth+1];
				break;
				case 1 : sum -= aArr[depth+1];
				break;
				case 2 : sum *= aArr[depth+1];
				break;
				case 3 : sum /= aArr[depth+1];
				break;
			};
			
			maxAndMin(aArr, operArr, depth+1, sum);
			sum = tmp;
			operArr[i] = operArr[i]+1;
			
			if(depth == 0)
				sum = aArr[0];
		}
	}
	
	private static void updateMaxAndMin(int target) {
		max = Math.max(max, target);
		min = Math.min(min, target);
	}

}
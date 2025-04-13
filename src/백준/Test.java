package 백준;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws InterruptedException, IOException {
		char a= '1';
		a = '1' - '0' + '0';
		System.out.println(a);

	}

	static long pow(int n, int size) {
		long result = 1L;
		for (int i = 0; i < size; i++) {
			result *= n;
		}
		return result;
	}
}
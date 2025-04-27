package bakjun;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Test {
	public static void main(String[] args) throws InterruptedException, IOException {
		List<Integer>[] listArr = new ArrayList[1001];
		listArr[2].add(1);

	}

	static long pow(int n, int size) {
		long result = 1L;
		for (int i = 0; i < size; i++) {
			result *= n;
		}
		return result;
	}
}
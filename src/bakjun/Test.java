package bakjun;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Test {
	public static void main(String[] args) throws InterruptedException, IOException {
		LinkedList<Integer> a = new LinkedList<>();
		a.offer(1);
		a.offer(2);
		a.offer(3);
		a.remove(1);


	}

	static long pow(int n, int size) {
		long result = 1L;
		for (int i = 0; i < size; i++) {
			result *= n;
		}
		return result;
	}
}
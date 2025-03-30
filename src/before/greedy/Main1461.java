package before.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1461 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int n = Integer.parseInt(token[0]);
        int m = Integer.parseInt(token[1]);

        String[] bookLocToken = br.readLine().split(" ");
        List<Integer> bookLocPlus = new ArrayList();
        List<Integer>  bookLocMinus = new ArrayList();
        for(int i=0;i<n;i++) {
            int book = Integer.parseInt(bookLocToken[i]);
            if (book>=0) {
                bookLocPlus.add(book);
                continue;
            }
            bookLocMinus.add(-1 * book);
        }

        Collections.sort(bookLocPlus, Collections.reverseOrder());
        Collections.sort(bookLocMinus, Collections.reverseOrder());

        boolean[] isLast = new boolean[2];
        if (!bookLocPlus.isEmpty() && (bookLocMinus.isEmpty() || bookLocPlus.get(0) > bookLocMinus.get(0))) {
            isLast[0] = true;
        } else {
            isLast[1] = true;
        }

        int sum = 0;
        for (int i = 0; i < bookLocPlus.size(); i++) {
            if (i==0 && isLast[0]) {
                sum += bookLocPlus.get(i);
                i+=m-1;
                continue;
            }
            sum +=bookLocPlus.get(i)*2;
            i+=m-1;
        }

        for (int i = 0; i < bookLocMinus.size(); i++) {
            if (i==0 && isLast[1]) {
                sum+=bookLocMinus.get(i);
                i+=m-1;
                continue;
            }
            sum+=bookLocMinus.get(i)*2;
            i+=m-1;
        }

        System.out.println(sum);
    }
}

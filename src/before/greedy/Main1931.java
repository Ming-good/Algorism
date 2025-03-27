package before.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Main1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] roomArr = new int[n][2];

        for(int i=0;i<n;i++) {
            String[] roomStr = br.readLine().split(" ");
            roomArr[i][0] = Integer.parseInt(roomStr[0]);
            roomArr[i][1] = Integer.parseInt(roomStr[1]);
        }

        Arrays.sort(roomArr, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        });

        List<int[]> list = new ArrayList();
        list.add(roomArr[0]);
        for(int i=1;i<roomArr.length;i++) {
            int[] cursor = list.get(list.size()-1);
            if (cursor[1] <= roomArr[i][0]) {
                list.add(roomArr[i]);
            }
        }

        System.out.println(list.size());
    }
}

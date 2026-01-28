package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main1736 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tkn = br.readLine().split(" ");
        int n = Integer.parseInt(tkn[0]);
        int m = Integer.parseInt(tkn[1]);

        List<Point> list = new ArrayList<>();
        int loop = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int val =  Integer.parseInt(st.nextToken());
                if (val > 0) {
                    list.add(new Point(j, i, false));
                }
            }
        }
        Collections.sort(list, (a,b) -> {
            if(a.x == b.x) return Integer.compare(a.y, b.y);
            return Integer.compare(a.x, b.x);
        });

        int removeCnt = 0;
        int robot = 0;
        while(removeCnt < list.size()) {
            int current = 0;
            for(Point p : list) {
                if(!p.isRemoved && p.y >= current) {
                    p.isRemoved = true;
                    current = p.y;
                    removeCnt++;
                }
            }
            robot++;
        }

        System.out.println(robot);
    }

    static class Point {
        int x,y;
        boolean isRemoved;

        public Point(int x, int y, boolean isRemoved) {
            this.x = x;
            this.y = y;
            this.isRemoved = isRemoved;
        }

        @Override
        public String toString() {
            return String.format("{%s, %s}", x, y);
        }
    }
}

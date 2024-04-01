package programers.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N {

    public static void main(String[] args) {
        N n = new N();
    }

    public int solution(int N, int number) {

        List<Set<Integer>> list = new ArrayList<>();
        int nn = 0;
        for (int i = 0; i < 8; i++) {
            nn=(nn*10)+N;
            if(nn == number) return i+1;

            HashSet<Integer> map = new HashSet<>(1);
            map.add(nn);

            list.add(map);

            if (findNumAndCal(list, N, number, i + 1)) return i+1;
        }

        return -1;
    }

    private boolean findNumAndCal(List<Set<Integer>> fx, int n,int number, int depth) {
        int left = (int) Math.ceil(depth / 2);
        int right = depth-left;

        Set<Integer> fxc = fx.get(depth-1);
        while(left<depth && right>0 && left>0){
            Set<Integer> fxa = fx.get((left++)-1);
            Set<Integer> fxb = fx.get((right--)-1);

            for (Integer a : fxa) {
                for (Integer b : fxb) {
                    if (a * b == 0) {
                        continue;
                    }
                    if(a+b==number || a*b==number || a==number || a/b==number || a-b==number) return true;
                    fxc.add(Math.abs(a - b));
                    fxc.add(a*b);
                    fxc.add(a/b);
                    fxc.add(a+b);
                    fxc.add(b/a);
                }
            }
        }
        return false;
    }
}

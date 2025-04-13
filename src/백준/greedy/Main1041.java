package 백준.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1041 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] token = br.readLine().split(" ");
        int[] nums = new int[6];

        long n1 = 1L*(n - 2) * (n - 2) * 5 + 1L*(n - 2) * 4;
        long n2 = 1L*8*n-12;
        long n3 = 4;

        for (int i=0;i<nums.length;i++) {
            nums[i] = Integer.parseInt(token[i]);
        }

        int total = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        if(n==1) {
            for (int i=0;i<6;i++) {
                max = Math.max(max, nums[i]);
                total += nums[i];
            }
            System.out.println(total-max);
            return;
        }

        for (int i = 0; i < 6; i++) {
            if(min> nums[i]) {
                min = nums[i];
            }
        }

        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        for(int i=0;i<6;i++) {
            for(int z=0;z<6;z++) {
                if (z == i || z + i == 5) {
                    continue;
                }
                list2.add(nums[i] + nums[z]);
                for (int j=0;j<6;j++) {
                    if(i == j || z==j || z+j==5 || i + j == 5) {
                        continue;
                    }
                    list3.add(list2.get(list2.size()-1) + nums[j]);
                }
            }
        }

        Collections.sort(list2);
        Collections.sort(list3);

        long sum1 = 1L*n1*min;
        long sum2 = 1L*n2*list2.get(0);
        long sum3 = 1L * n3 * list3.get(0);

        System.out.println(sum1 + sum2 + sum3);
    }

}

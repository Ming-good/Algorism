package programers.dp;

import java.util.Arrays;

public class Operations {

    public static void main(String[] args) {
        String arr[] = {"5", "-", "10", "+", "1", "+", "2", "-", "4"};
        Operations operations = new Operations();

        System.out.println(operations.solution(arr));
    }

    public int solution(String arr[]) {
        int len = arr.length / 2 + 1;
        int[] dpArr = new int[len];
        int[][] max = new int[len][len];
        int[][] min = new int[len][len];

        for (int i = 0; i < arr.length; i+=2) {
            int num = Integer.valueOf(arr[i]);
            if (i == 0) {
                dpArr[i] = num;
                continue;
            }

            dpArr[i/2] = arr[i-1].equals("-") ? -num : num;
        }

        for (int i = 0; i <len ; i++) {
            for (int j = 0;j<len-i;j++) {
                if (i == 0) {
                    max[i][j] = dpArr[j];
                    min[i][j] = dpArr[j];
                    continue;
                }
                int depth = i;
                int maxRight = max[i - 1][j + 1];
                int maxLeft = max[i - 1][j];
                int minRight = min[i-1][j+1];
                int minLeft = min[i-1][j];

                int[] valArr = new int[8];

                int maxLeftVal = maxLeft + dpArr[j + depth];
                int maxRightVal = Math.abs(dpArr[j]) + maxRight;
                int minLeftVal = Math.abs(minLeft) + dpArr[j + depth];
                int minRightVal = Math.abs(dpArr[j]) + minRight;

                valArr[0] =  maxLeftVal;
                valArr[1] = dpArr[j]<0? -maxRightVal : maxRightVal;
                valArr[2] = minLeft < 0 ? -minLeftVal : minLeftVal;
                valArr[3] = dpArr[j]<0? -minRightVal : minRightVal;
                valArr[4]=maxLeft + dpArr[j + depth];
                valArr[5]=dpArr[j] + maxRight;
                valArr[6]=minLeft + dpArr[j + depth];
                valArr[7]=dpArr[j] + minRight;

                max[i][j] = Arrays.stream(valArr).summaryStatistics().getMax();
                min[i][j] = Arrays.stream(valArr).summaryStatistics().getMin();

            }
        }

        return max[len-1][0];
    }

}
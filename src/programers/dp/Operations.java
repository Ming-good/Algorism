package programers.dp;

public class Operations {

    public static void main(String[] args) {
        String arr[] = {"1", "-", "3", "-", "5", "-", "8"};
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
                int maxRight = dpArr[j + 1] < 0 ? -Math.abs(max[i - 1][j + 1]) : max[i - 1][j + 1];
                int maxLeft = Math.abs(max[i - 1][j]);
                int minRight = min[i-1][j+1];
                int minLeft = min[i-1][j];

                int maxLeftVal = maxLeft + dpArr[j + depth];
                if (maxLeftVal < 0) {
                    maxLeftVal = -maxLeftVal;
                }

                max[i][j] = Math.max(maxLeftVal<0?-maxLeftVal:maxLeftVal, dpArr[j] + maxRight);
                min[i][j] = Math.min(minLeft + dpArr[j + depth], dpArr[j] + minRight);

                max[i][j] = Math.max(max[i][j], min[i][j]);
                min[i][j] = Math.min(max[i][j], min[i][j]);
            }
        }

        return max[len-1][0];
    }

}
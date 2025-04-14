package bakjun.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main24060 {

    private static int cnt;
    private static int store = 0;
    private static int[] tmp;
    private static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        tmp = new int[size[0]];
        cnt = size[1];

        merge_sort(numbers, 0, size[0]-1);

        System.out.print(result);
    }
//0 1 2 3 4 5
    private static void merge_sort(int[] arr, int start, int end) {
        if (cnt < store) {
            return;
        }
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(arr, start, mid);
            merge_sort(arr, mid+1, end);
            merge(arr,start,mid,end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
                continue;
            }
            tmp[t++] = arr[j++];
        }

        while (i <= mid) {
            tmp[t++] = arr[i++];
        }

        while (j <= end) {
            tmp[t++] = arr[j++];
        }
        i = start;
        t = 0;
        while (i <= end) {
            store++;
            if (cnt == store) {
                result = tmp[t];
                break;
            }
            arr[i++] = tmp[t++];
        }
    }
}

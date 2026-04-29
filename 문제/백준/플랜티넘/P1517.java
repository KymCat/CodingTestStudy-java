package 백준.플랜티넘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

// 백준 서비스 종료로 인해 해당 풀이가 틀릴 수 도 있습니다.
public class P1517 {
    public static long mergeSort(int[] arr, int left, int right, long swap) {
        if (left >= right) return swap;
        int mid = (left + right) / 2;
        long sum = swap;

        sum += mergeSort(arr, left, mid, swap);
        sum += mergeSort(arr, mid + 1, right, swap);


        sum += merge(arr, left, mid, right);
        return sum;
    }

    private static long merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        long swap = 0;
        int leftIdx = left;
        int rightIdx = mid + 1;
        int tempIdx = 0;

        while (leftIdx <= mid && rightIdx <= right) {
            if(arr[leftIdx] <= arr[rightIdx]) {
                temp[tempIdx++] = arr[leftIdx++];
            }
            else {
                temp[tempIdx++] = arr[rightIdx++];
                swap += mid + 1 - leftIdx;  // swap 횟수 계산
            }
        }

        while (leftIdx <= mid) temp[tempIdx++] = arr[leftIdx++];
        while (rightIdx <= right) temp[tempIdx++] = arr[rightIdx++];

        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }

        return swap;
    }

    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(mergeSort(arr, 0, n-1, 0));
    }
}

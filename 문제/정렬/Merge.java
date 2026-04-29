package 정렬;

/*
    병합 정렬 : 분할-정복 방식을 사용해 데이터를 분할하고 분할한 집합을 정렬하며 합치는 알고리즘 O(nlogN)
 */
public class Merge {
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;

        // 쪼개기
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // 병합
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int leftIdx = left;
        int rightIdx = mid + 1;
        int tempIdx = 0;

        // 왼쪽, 오른쪽 배열에서 작은 값을 선택해서 옮기기
        while (leftIdx <= mid && rightIdx <= right) {
            // 왼쪽 배열에서 작은값이 나올 경우
            if (arr[leftIdx] <= arr[rightIdx])
                temp[tempIdx++] = arr[leftIdx++];
            else
                temp[tempIdx++] = arr[rightIdx++];
        }

        // 배열에 남은 값을 temp로 옮기기
        while (leftIdx <= mid) temp[tempIdx++] = arr[leftIdx++];
        while (rightIdx <= right) temp[tempIdx++] = arr[rightIdx++];

        // temp 값들을 원본 배열(arr) 로 복사하기
        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];    // 현재 처리중인 배열 시작에 맞출 수 있게 left + i
        }
    }


    static void main() {
        int[] arr = {42, 32, 24, 60, 15, 5, 90, 45};
        mergeSort(arr, 0, arr.length-1);

        for (int value : arr)
            System.out.print(value + " ");
    }

}

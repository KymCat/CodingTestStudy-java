package 정렬;

/*
    퀵 정렬 : 기준값(Pivot)을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해 정렬 O(nlogN)
 */
public class Quick {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = arr[(left + right) / 2];
        int partition = partition(arr, pivot, left, right); // 파티션 분리 시작

        // 각 파티션끼리 정렬
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition, right);
    }

    // 파티션 Pivot 값 기준으로 분리 (왼쪽 : 작은 값, 오른쪽 : 큰값)
    private static int partition(int[] arr, int pivot, int left, int right) {
        while(left <= right) {
            while(arr[left] < pivot) left++;    // 왼쪽에서 pivot 보다 큰 값이 나올 때 까지 left++ 반복
            while(arr[right] > pivot) right--;  // 오른쪽에서 pivot 보다 작은 값이 나올 때 까지 right-- 반복

            // 아직 left, right 가 만나지 않았다면 멈춘 값들을 Swap
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    static void main() {
        int[] arr = {42,32,24,60,15,5,90,45};
        quickSort(arr, 0, arr.length-1);

        for (int value : arr)
            System.out.print(value + " ");
    }
}

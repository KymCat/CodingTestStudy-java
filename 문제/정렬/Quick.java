package 정렬;

public class Quick {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = arr[(left + right) / 2];
        int partition = partition(arr, pivot, left, right);

        quickSort(arr, left, partition - 1);
        quickSort(arr, partition, right);
    }

    private static int partition(int[] arr, int pivot, int left, int right) {
        while(left <= right) {
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;

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

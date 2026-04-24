package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    버블 정렬 : 데이터의 `인접한 요소`끼리 비교하고,
               `Swap` 연산을 수행하며 정렬하는 방식 O(n**2)

    input   output
    5       1
    5       2
    2       3
    3       4
    4       5
    1

    1번째 줄에 수의 개수 N
    2번째 줄부터 N개의 줄에 숫자가 주어짐
 */
public class Bubble {
    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {

                if(arr[j] > arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}

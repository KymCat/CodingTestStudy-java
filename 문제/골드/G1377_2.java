package 골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    백준 1377번 버블 소트 문제 - 속도 최적화 (mdwgti16 님 코드)
    기존 객체 정렬 -> 계수(Counting) 정렬 응용으로 최적화

    1372 ms -> 284 ms
 */
public class G1377_2 {
    private static final int MAX_INDEX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];     // value 배열
        int[] cnt = new int[MAX_INDEX];   // 인덱스가 value, 해당 value 가 몇개 있는지 카운팅

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            cnt[arr[i]]++;
        }

        int prefixSum = 0;
        for (int i = 0; i < MAX_INDEX; i++) {
            prefixSum += cnt[i];    // 누적합 계산
            cnt[i] = prefixSum - 1; // 정렬되었을 때의 인덱스 위치 계산
        }

        int maxValue = 0;
        for (int i = 0; i < n; i++)
            maxValue = Math.max(maxValue, i - cnt[arr[i]]); // 정렬 전 인덱스 - 정렬 후 인덱스

        System.out.println(maxValue + 1);
    }
}

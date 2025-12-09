package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A); // 오름차순 정렬

        int start = 0; // 첫 인덱스
        int end = n-1; // 끝 인덱스
        int cnt = 0;

        // 핵심 풀이
        // 오름차순 정렬을 했으므로 start는 항상 end보다 작은 수를 가리키고, end는 start보다 항상 큰 수를 가리킨다.
        // 합이 m 이라면 양 끝 포인터는 서로서로 1칸씩 가까워져야한다.
        // 합이 m보다 작아지면 작은 수를 가리키고 있는 start가 커져야한다.
        // 합이 m보다 커지면 큰 수를 가리키고 있는 end가 작아져야한다
        while (start < end) {
            if (A[start] + A[end] == m) {
                start++;
                end--;
                cnt++;
            } else if (A[start] + A[end] > m) end--;
            else start++;
        }
        System.out.println(cnt);
    }
}

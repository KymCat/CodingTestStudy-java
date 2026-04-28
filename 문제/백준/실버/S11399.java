package 백준.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 서비스 종료로 인해 해당 풀이가 틀릴 수 도 있습니다.
public class S11399 {
    static void insertSort(int[] p) {
        for (int i = 1; i < p.length; i++) {
            int j = i-1;
            int target = p[i];

            while(j >= 0 && target < p[j]) {
                p[j+1] = p[j];
                j--;
            }

            p[j+1] = target;
        }
    }

    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        insertSort(p); // 삽입정렬
        int[] s = new int[n];   // 누적합 배열
        s[0] = p[0];
        for (int i = 1; i < n; i++) {
            s[i] = s[i-1] + p[i];
        }

        System.out.println(Arrays.stream(s).sum());
    }
}

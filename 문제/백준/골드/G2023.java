package 백준.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 서비스 종료로 인해 해당 풀이가 틀릴 수 도 있습니다.
public class G2023 {
    public static int n;            // 신비한 소수 찾을 자릿수

    /*
        num : 소수 판별할 숫자
        len : 자릿수
     */
    public static void dfs(int num, int len) {
        if (len == n) {  // 신비한 소수
            System.out.println(num);
            return;
        }

        for (int i = 1; i <= 9; i+=2) {
            int nextNum = num * 10 + i;

            if (prime(nextNum))
                dfs(nextNum, len + 1);
        }

    }

    // 소수 판별
    public static boolean prime(int num) {
        for (int i = 2; i < Math.sqrt(num) + 1; i++)
            if (num % i == 0) return false;

        return true;
    }

    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }
}

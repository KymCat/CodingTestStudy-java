package 골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수열 개수
        int m = Integer.parseInt(st.nextToken()); // 나누는 수

        st= new StringTokenizer(br.readLine());
        long[] S = new long[n]; // 구간합 배열
        long[] C = new long[m]; // 나머지 값 배열

        S[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        // m으로 나누고 나머지를 C 배열에 갯수 채우기
        for (int i = 0; i < n; i++) {
            int mod = (int) (S[i]%m);
            if (mod == 0) answer++;
            C[mod]++;
        }

        for (int i = 0; i < m; i++) {
            if(C[i] > 1) // 갯수가 1 이상이면
                answer += (C[i] * (C[i]-1) / 2);
        }

        System.out.println(answer);
    }
}

package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 합배열
        long[] S = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++)
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(S[j] - S[i-1]).append("\n");
        }

        System.out.println(sb);

    }
}

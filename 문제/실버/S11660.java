package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11660 {
    public static void main(String[] args) throws IOException {
        // n,m 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 입력 배열 처리
        int[][] A = new int[n+1][n+1];
        for (int i = 1; i <=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구간합 배열 초기화
        int[][] D = new int[n+1][n+1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n; j++) {
                D[i][j] = A[i][j] + D[i-1][j] + D[i][j-1] - D[i-1][j-1];
            }
        }

        StringBuffer sb = new StringBuffer();
        // m 처리
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1] ;
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}

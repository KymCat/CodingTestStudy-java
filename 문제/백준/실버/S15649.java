package 백준.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 서비스 종료로 인해 해당 풀이가 틀릴 수 도 있습니다.
public class S15649 {
    static int n;
    static int m;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth) {
        if (depth > m) {
            for (int i = 1; i <=m; i++)
                sb.append(result[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            result[depth] = i;
            dfs( depth + 1);
            visited[i] = false;
        }
    }

    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        result = new int[n+1];

        dfs(1);

        System.out.println(sb);
    }
}

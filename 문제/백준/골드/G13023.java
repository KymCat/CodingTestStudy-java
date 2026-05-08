package 백준.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 서비스 종료로 인해 해당 풀이가 틀릴 수 도 있습니다.
public class G13023 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false;

    public static void dfs(int node, int depth) {
        if (depth == 5) {
            found = true;
            return;
        }

        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
                if (found) return;
            }
        }

        visited[node] = false;

    }

    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 1);

            if (found)break;
        }

        System.out.println(found ? 1 : 0);
    }
}

package 백준.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 서비스 종료로 인해 해당 풀이가 틀릴 수 도 있습니다.
public class S11724 {
    static boolean[] visited;

    static void dfs(ArrayList<Integer>[] graph, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node]) continue;

            visited[node] = true;
            for (int next : graph[node]) {
                if (!visited[next])
                    stack.push(next);
            }
        }
    }

    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u); // 무방향 그래프
        }

        int cnt = 0;
        for (int i = 1; i < n+1; i++) {
            if (!visited[i]) {
                dfs(graph, i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

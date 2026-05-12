package 백준.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 서비스 종료로 인해 해당 풀이가 틀릴 수 도 있습니다.
public class S1260 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int n;   // 노드의 개수
    static int m;   // 에지의 개수
    static int v;   // 시작점

    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        // insert
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // sort
        for (int i = 1; i <= n; i++)
            Collections.sort(graph[i]);

        dfs(v);
        sb.append("\n");
        for (int i = 0; i <= n; i++)
            visited[i] = false;

        bfs(v);
        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int next : graph[node]) {
            if (!visited[next])
                dfs(next);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            sb.append(node).append(" ");
            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        sb.append("\n");
    }
}

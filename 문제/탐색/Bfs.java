package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    입력      출력
    6 6   1 2 3 5 6 4
    1 2
    1 3
    2 6
    3 4
    2 5
    4 6
 */

public class Bfs {
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int n;
    static int m;

    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[n + 1];

        // insert
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        
        // sort
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        bfs(1);
        System.out.println(sb);
    }

    static void bfs(int start) {
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}

package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Stream;

/*
    깊이 우선 탐색(DFS) : 그래프 완전 탐색 기법 중 하나,
        그래프의 시작 노드에서 출발하여 탐색한 한 쪽 분기를 정하여 `최대 깊이` 까지 탐색을 마친 후
        다시 다른 쪽 분기로 이동하여 다시 탐색을 수행하는 알고리즘
 */
public class Dfs {
    public static void dfs(ArrayList<Integer>[] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node]) continue;

            visited[node] = true;
            System.out.print(node + " ");

            for (int next : graph[node]) {
                if (!visited[next])
                    stack.push(next);
            }
        }
    }

    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nodeEdge = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int node = nodeEdge[0];
        int edge = nodeEdge[1];

        ArrayList<Integer>[] graph = new ArrayList[node + 1];   // 노드 시작을 1부터 하기 위해 node + 1
        for (int i = 1; i <= node; i++)
            graph[i] = new ArrayList<>();

        for (int i = 1; i <= edge; i++) {
            int[] edgeUV = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int u = edgeUV[0];
            int v = edgeUV[1];
            graph[u].add(v);
            graph[v].add(u);    // 무방향 그래프
        }

        dfs(graph, 1);
    }
}

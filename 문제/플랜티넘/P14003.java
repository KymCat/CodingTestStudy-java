package 플랜티넘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            while (!queue.isEmpty() && queue.getLast().value > cur)
                queue.removeLast();

            queue.addLast(new Node(i,cur));
            if(i - l >= queue.getFirst().index)
                queue.removeFirst();

            sb.append(queue.getFirst().value).append(" ");
        }

        System.out.println(sb);

    }

    static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}

package 플랜티넘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P1306 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = 2*m - 1; // window size

        Deque<Node> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        // i는 윈도의 끝을 가리키고 있음
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (!dq.isEmpty() && dq.getFirst().index <= i - k)
                dq.removeFirst();

            while (!dq.isEmpty() && dq.getLast().value < cur)
                dq.removeLast();
            dq.addLast(new Node(i, cur));

            if (i >= k-1)
                sb.append(dq.getFirst().value).append(' ');
        }

        System.out.println(sb);
    }

    private static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}

package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 1;                            // 오름차순 자연수
        Stack<Integer> stack = new Stack<>();   // 스택
        StringBuilder sb = new StringBuilder(); // 결과 저장
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine()); // 현재 수열값

            while (cur >= num) {
                stack.push(num++);
                sb.append("+\n");
            }

            if (stack.pop() != cur) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
            else sb.append("-\n");
        }

        System.out.println(sb);
    }
}

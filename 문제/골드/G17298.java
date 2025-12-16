package 골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class G17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 단조 증가 스택
            // 스택의 의미 : 아직 오큰수를 찾지못한 인덱스들의 모음
            // 단조 증가 : 현재 값이 더 커질 때 이전 후보들이 제거되는 비교 규칙
            while (!stack.isEmpty() && num[i] > num[stack.peek()]) {
                result[stack.pop()] = num[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty())
            result[stack.pop()] = -1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(result[i]).append(' ');
        System.out.println(sb);
    }
}

package 실버;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int countA = (int) str.chars()
                .filter(ch -> ch == 'a')
                .count();

        int n = str.length();

        // a의 갯수가 0이거나 a만 존재할 경우
        if (countA == 0 || countA == n) {
            System.out.println(0);
            return;
        }

        int countB = 0;
        for (int i = 0; i < countA; i++) {
            if (str.charAt(i) == 'b') countB++;
        }

        int answer = countB;
        for (int i = 1; i < n; i++) {
            int left = (i -1) % n;      // 빠져나갈 문자
            int right = (i + countA -1) % n;   // 삽입될 문자

            if (str.charAt(left) == 'b') countB--;
            if (str.charAt(right) == 'b') countB++;

            answer = Math.min(answer, countB);
        }

        System.out.println(answer);
    }
}

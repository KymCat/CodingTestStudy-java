package 브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] lst = br.readLine().split(" ");
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(lst[i]);
            sum+=score;
            max = Math.max(max, score);
        }

        System.out.println(sum * 100.0 / max / N);
    }
}

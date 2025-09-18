package 브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "=");
            long answer = calc(st.nextToken());
            long result = Long.parseLong(st.nextToken().trim());

            if (answer == result) System.out.println("correct");
            else System.out.println("wrong answer");
        }
    }

    private static long calc(String token) {
         String[] parts = token.split(" ");

         long left = Long.parseLong(parts[0]);
         String op = parts[1];
         long right = Long.parseLong(parts[2]);

        long result = 0;
        switch (op) {
            case "+" :
                result = left + right;
                break;
            case "-" :
                result = left - right;
                break;
            case "*" :
                result = left * right;
                break;
            case "/" :
                result = left / right;
                break;
        }
        return result;
    }
}

package 브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17201 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String magnet = br.readLine();

        System.out.println(solution(magnet, n));

    }

    public static String solution(String magnet, int n) {
        char start = magnet.charAt(0);
        for (int i = 1; i < 2*n; i++) {
            if (start == magnet.charAt(i)) return "No";
            start = magnet.charAt(i);
        }
        return "Yes";
    }
}

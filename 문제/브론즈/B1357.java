package 브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken());
            sum += Integer.parseInt(sb.reverse().toString());
            sb.setLength(0);
        }

        sb.append(String.valueOf(sum));
        System.out.println(Integer.parseInt(sb.reverse().toString()));
    }
}

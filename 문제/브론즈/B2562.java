package 브론즈;

import java.io.*;

public class B2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            int cnt = Integer.parseInt(br.readLine());
            if (cnt > max) {
                max = cnt;
                idx = i;
            }
        }

        System.out.println(max);
        System.out.println(idx+1);

        br.close();
    }
}

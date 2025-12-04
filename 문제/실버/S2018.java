package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int start_idx = 1;
        int end_idx = 1;
        int sum = 1;

        /*
        * sum > N : sum-=start_idx, start_idx++
        * sum < N : sum+=end_idx, end_idx++
        * sum == N : sum+=end_idx, end_idx++, count++
        */

        while (end_idx != n) {
            if (sum == n) {
                end_idx++;
                sum+=end_idx;
                count++;
            }
            else if (sum > n) {
                sum-=start_idx;
                start_idx++;
            } else {
                end_idx++;
                sum+=end_idx;
            }
        }

        System.out.println(count);
    }
}

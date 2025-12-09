package 골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] A = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int cnt = 0;
        for (int k = 0; k < n; k++) {
            long find = A[k];
            int i = 0;
            int j = n-1;

            while(i < j) {
                if(A[i] + A[j] == find) {
                    if (i != k && j != k) {
                        cnt++;
                        break;
                    }
                    else if (i == k) i++;
                    else if (j == k) j--;

                } else if (A[i] + A[j] > find) j--;
                else i++;
            }
        }

        System.out.println(cnt);
    }
}

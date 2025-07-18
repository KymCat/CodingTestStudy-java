package 브론즈;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1837 {
    static int K;
    static char[] P;
    static boolean[] checked;
    static List<Integer> primes = new ArrayList<>();

    static boolean isGoodPassword(int prime) {
        int r = 0;

        for (char p : P)
            r = (r * 10 + (p - '0')) % prime;

        return r == 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = st.nextToken().toCharArray();
        K = Integer.parseInt(st.nextToken());

        checked = new boolean[K + 1];

        // 애라토스테네스의 체
        for (int i = 2; i < K; i++) {
            if (!checked[i]) {
                primes.add(i);
                for (int j = i; j < K; j+=i)
                    checked[j] = true;
            }
        }

        for (Integer prime : primes) {
            if (isGoodPassword(prime)) {
                System.out.println("BAD " + prime);
                return;
            }
        }

        System.out.println("GOOD");
        br.close();

    }
}

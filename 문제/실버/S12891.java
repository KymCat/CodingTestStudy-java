package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S12891 {
    static int[] check; // 부분 문자열 A C G T 최소 개수 배열
    static int[] cur;   // 현재 윈도우 A C G T 개수 배열
    static int req;     // 최소 개수에 만족하는 알파벳 개수 (max: 4)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result = 0;

        char[] dna = new char[s]; // DNA 문자배열
        check = new int[4];
        cur = new int[4];      // 현재 윈도우 A C G T 개수 배열

        dna = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
            if(check[i] == 0) req++;
        }

        for (int i = 0; i < p; i++) {
            addCount(dna[i]);
        }
        if (req == 4) result++;

        for (int i = p; i < s; i++) {
            int j = i - p;
            addCount(dna[i]);
            removeCount(dna[j]);
            if (req == 4) result++;
        }
        System.out.println(result);
        br.close();
    }

    private static void addCount(char c) {
        switch (c) {
            case 'A' :
                cur[0]++;
                if (cur[0] == check[0])
                    req++;
                break;

            case 'C' :
                cur[1]++;
                if (cur[1] == check[1])
                    req++;
                break;

            case 'G' :
                cur[2]++;
                if (cur[2] == check[2])
                    req++;
                break;

            case 'T' :
                cur[3]++;
                if (cur[3] == check[3])
                    req++;
                break;
        }
    }

    private static void removeCount(char c) {
        switch (c) {
            case 'A' :
                if (cur[0] == check[0])
                    req--;
                cur[0]--;
                break;

            case 'C' :
                if (cur[1] == check[1])
                    req--;
                cur[1]--;
                break;

            case 'G' :
                if (cur[2] == check[2])
                    req--;
                cur[2]--;
                break;

            case 'T' :
                if (cur[3] == check[3])
                    req--;
                cur[3]--;
                break;
        }
    }
}

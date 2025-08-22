package 브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B11945{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        // int m = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();
        StringBuilder input = new StringBuilder();

        // 메모리를 효율적이게 해보자 ->  String을 최대한 줄임
        for (int i = 0; i < n; i++) {
            input.setLength(0);
            input.append(br.readLine());
            answer.append(input.reverse() + "\n");
        }

        System.out.println(answer);

        /* 처음 작성한 코드
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);

        List<StringBuffer> lst = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer(br.readLine());
            lst.add(sb.reverse());
        }

        for (StringBuffer s : lst)
            System.out.println(s);

        */
    }
}

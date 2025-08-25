package 브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        HashMap<String, Integer> names = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            names.merge(name.substring(0,1), 1, Integer::sum);
        }

        StringBuilder answer = new StringBuilder();
        for(Map.Entry<String, Integer> name : names.entrySet()) {
            if (name.getValue() >= 5)
                answer.append(name.getKey());
        }

        System.out.println(answer.isEmpty() ? "PREDAJA" : answer);
    }
}

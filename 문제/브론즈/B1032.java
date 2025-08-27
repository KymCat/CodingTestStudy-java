package 브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String first_file = br.readLine();

        List<String> files = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            files.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < first_file.length(); i++) {
            char pattern = first_file.charAt(i);
            for (String file : files) {
                if (pattern != file.charAt(i)) {
                    pattern = '?';
                    break;
                }
            }
            sb.append(pattern);
        }

        System.out.println(sb);

    }
}

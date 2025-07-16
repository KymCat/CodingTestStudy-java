package 브론즈;

import java.io.*;

public class B5717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = br.readLine().split(" ");

            int boy = Integer.parseInt(input[0]);
            int girl = Integer.parseInt(input[1]);
            if (boy == 0 && girl == 0)
                break;

            System.out.println(boy + girl);
        }
    }
}

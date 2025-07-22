package 브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());

        System.out.println(Math.PI*r*r);
        System.out.println(2.0*r*r);
    }
}

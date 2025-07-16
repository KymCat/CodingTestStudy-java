package 브론즈;

import java.io.*;

public class B2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inpput = br.readLine().split(" ");
        int a = Integer.parseInt(inpput[0]);
        int b = Integer.parseInt(inpput[1]);
        int c = Integer.parseInt(inpput[2]);


        if(a == c && c == b)
            System.out.println(10000 + (a * 1000));
        else if (a == b || a == c)
            System.out.println(1000 + (a * 100));
        else if (b == c)
            System.out.println(1000 + (b * 100));
        else {
//            int max = 0;
//            int[] dice = { a,b,c };
//            for (int i : dice) max = Math.max(i, max);
            System.out.println(Math.max(Math.max(a,b), c) * 100);
        }

    }
}

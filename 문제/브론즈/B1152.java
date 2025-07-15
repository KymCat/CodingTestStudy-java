package 브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// import java.io.*;

public class B1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] str = br.readLine().split(" ");
//
//        int answer = str.length;
//        for (String s : str)
//            if (s.equals("")) answer--;

        // StringTokenizer가 훨씬 빠르다 !
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.println(st.countTokens());
    }
}

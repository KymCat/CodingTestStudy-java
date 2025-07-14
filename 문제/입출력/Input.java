package 입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Input {
    public static void main(String[] args) throws IOException {
        /*
            Scanner보다 빠른 BufferedReader를 사용한다.
            단 정수를 입력받는 함수를 제공하지 않기 때문에 필요한 경우 "직접" 변환 해야함
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(input.getClass()); // class java.lang.String

        // 문자열 -> 정수
        Integer toInteger = Integer.parseInt(input);
        System.out.println(toInteger.getClass()); // class java.lang.Integer

        /*
            입력 방식
            30 40
         */
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br2.readLine().split(" ");
        System.out.println(Arrays.asList(split)); // [30, 40]

    }
}

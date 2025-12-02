package 정렬;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Basic {
    public static void main(String[] args) {

        // 오름차순
        int[] A = {5,4,3,2,1};
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));


        // 내림차순 방법 2가지
        // 1. Collections.reverseOrder() 사용
        // 2. 모든 데이터를 음수로 전환후 Arrays.sort() 사용

        // Collections.reverseOrder() 방법
        Integer[] B = {1,2,3,4,5}; // 클래스형 배열 사용
        Arrays.sort(B, Collections.reverseOrder());
        System.out.println(Arrays.toString(B));


        // 모든 데이터 음수 전환 방법
        int[] C = {1,2,3,4,5};
        negate(C); // 모든 데이터 음수로 만들기
        Arrays.sort(C);
        negate(C); // 다시 부호 반전
        System.out.println(Arrays.toString(C));
    }

    private static void negate(int[] c) {
        for (int i = 0; i < c.length; i++) {
            c[i]*=-1;
        }
    }
}

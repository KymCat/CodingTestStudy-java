package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    선택 정렬 : 최대 혹은 최소 데이터를 데이터가 나열된 순으로 찾아가며 선택하는 방법 O(n**2)

    백준 1427번 소트인사이드 문제
    Input   Output
    2143    4321

    입력한 데이터를 내림차순으로 정렬
 */
public class Selection {
    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[str.length()];

        // 문자열로 입력을 받고 `.subString()` 을 이용해 자릿수 분리
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }

        // 선택정렬 시작
        for (int i = 0; i < str.length(); i++) {
            int maxIdx = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (arr[maxIdx] < arr[j])
                    maxIdx = j;
            }

            if (arr[maxIdx] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.print(arr[i]);
        }

    }
}

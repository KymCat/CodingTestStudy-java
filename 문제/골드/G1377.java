package 골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G1377 {
    protected static class mData implements Comparable<mData> {
        int value;
        int index;

        public mData(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(mData o) { // value 기준 오름차순 정렬하기
//          return this.value - o.value;
            return Integer.compare(this.value, o.value);

        }
    }

    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        mData[] arr = new mData[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);

        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if(maxValue < arr[i].index - i)
                maxValue = arr[i].index -i;
        }

        System.out.println(maxValue + 1);
    }
}

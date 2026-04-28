package 정렬;

public class Insert {
    static void main() {
        int [] data = {42, 32, 24, 60, 40};

        // 오름차순 정렬
        for (int i = 1; i < data.length; i++) {
            int j = i-1;            // 정렬된 데이터 범위 끝
            int target = data[i];   // 정렬 할 데이터

            // 조건이 만족하면 데이터 쉬프트 연산 하기
            while(j >= 0 && target < data[j]) {
                data[j + 1] = data[j];
                j--;
            }

            // 적절한 위치에 삽입
            data[j+1] = target;
        }

        for (int value : data)
            System.out.print(value + " ");
    }
}

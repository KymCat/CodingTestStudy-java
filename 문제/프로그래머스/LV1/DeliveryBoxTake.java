package 프로그래머스.LV1;

import java.util.ArrayList;
import java.util.List;

/*
    2025 프로그래머스 코드챌린지 2차 예선 - 택배 상자 꺼내기
 */
public class DeliveryBoxTake {
    public static class Box {
        private int boxNumber;
        private int floor;
        private int idx;

        public Box(int boxNumber, int floor, int idx) {
            this.boxNumber = boxNumber;
            this.floor = floor;
            this.idx = idx;
        }

        public int getBoxNumber() {
            return boxNumber;
        }

        public int getFloor() {
            return floor;
        }

        public int getIdx() {
            return idx;
        }
    }

    public static int solution(int n, int w, int num) {
        List<Box> boxes = new ArrayList<>();
        int floor = (n + w - 1) / w;

        // 1층만 초기화
        for (int i = 1; i <= w; i++)
            boxes.add(new Box(i, 1, i-1));


        // 2층부터 초기화
        for (int i = 2; i <= floor; i++) {

            int startNumber = (i-1)*w + 1;
            int endNumber = startNumber + w - 1;

            for (int j = startNumber; j <= endNumber; j++) {   // j = box number
                if (j <= n) {
                    if (i % 2 == 0)
                        boxes.add(new Box(j, i, endNumber % j));
                    else
                        boxes.add(new Box(j, i, j % startNumber));
                }
            }
        }

        // 꺼내려는 택배 박스
        Box findBox = boxes.stream()
                .filter(box -> box.getBoxNumber() == num)
                .findFirst().get();

        // 꺼내려는 택배 박스보다 높은 층에있는 박스 갯수 구하기
        int count = (int) boxes.stream()
                .filter(box -> box.getIdx() == findBox.getIdx())
                .filter(box -> box.getFloor() > findBox.getFloor())
                .count();

        // 꺼내려는 택배 박스 포함하기 위해 +1
        return count + 1;
    }

    static void main() {
        System.out.println(solution(13, 3, 6));
    }
}

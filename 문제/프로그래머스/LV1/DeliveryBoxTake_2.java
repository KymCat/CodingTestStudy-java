package 프로그래머스.LV1;

/*
    2025 프로그래머스 코드챌린지 2차 예선 - 택배 상자 꺼내기
    수학적 접근
 */
public class DeliveryBoxTake_2 {
    /*
           n : 창고에 있는 박스 갯수
           w : 한 층의 놓을 수 있는 박스 갯수
           num : 꺼내려는 박스 번호
    */
    public static int solution(int n, int w, int num) {
        int maxFloor = (n + w - 1) / w - 1;     // 최대 층

        // 꺼내려는 박스(num) 정보
        int floor = (num - 1) / w;  // 0층부터 시작
        int offset = (num - 1) % w; // 해당 층에서의 인덱스 (0부터 시작)
        int col = (floor % 2 == 0) ? offset : w - 1 - offset; // 최하층이 0 이므로 짝수

        // 꺼내려는 박스(num) 보다 높은 층 갯수
        int upperFloors = maxFloor - floor - 1; // 0층부터 시작하므로 -1 추가
        
        // 맨 윗층 같은 열(col)에 박스가 있는지 검사
        // 1. 맨 윗층 시작번호 알아내기
        // 2. num 과 같은 열(col)에 있는 박스 숫자 구하기
        int start = (maxFloor - 1) * w + 1;
        int sameColNum = ((maxFloor - 1) % 2 == 0) ? start + col : start + (w - 1 - col);   // 층이 0부터 시작하므로 maxFloor - 1
        if (sameColNum > n) // 맨 윗층 같은 열 숫자가 박스 개수 보다 크면 하나 감소
            upperFloors--;

        return upperFloors + 1; // 꺼내려는 박스도 포함해서 + 1
    }

    static void main() {
        System.out.println(solution(22, 6, 8));
    }
}

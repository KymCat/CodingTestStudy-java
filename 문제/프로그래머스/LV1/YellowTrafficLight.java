package 프로그래머스.LV1;

/*
    2025 카카오 하반기 1차 - 노란불 신호등 문제
 */
public class YellowTrafficLight {
    public static int solution(int[][] signals) {
        int maxTime = 1;
        for (int[] curArr : signals)
            maxTime *= (curArr[0] + curArr[1] + curArr[2]);
        // maxTime : 최소공배수(lcm) 으로 구하는 것이 좋음

        for (int t = 1; t <= maxTime; t++) { // t -> current time

            boolean allYellow = true;
            for (int[] curArr : signals) {
                int g = curArr[0];  // green
                int y = curArr[1];  // yellow
                int r = curArr[2];  // red

                int cycle = g + y + r;
                int time = (t - 1) % cycle + 1; // 시간은 1초부터 시작

                if (!(g < time && time <= g + y)) {
                    allYellow = false;
                    break;
                }
            }
            if (allYellow) return t;
        }
        return -1;
    }

    static void main() {
        int[][] signals = {
                {2, 3, 2}, {3, 1, 3}, {2, 1, 1}
        };

        System.out.println(solution(signals));
    }

}

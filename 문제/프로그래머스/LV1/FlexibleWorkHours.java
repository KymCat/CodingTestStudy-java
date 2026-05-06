package 프로그래머스.LV1;

/*
    2025 프로그래머스 코드챌린지 1차 예선 - 유연근무제
 */
public class FlexibleWorkHours {
    public static int solution(int[] schedules, int[][] timelogs, int startday) {

        // 출근 허용시간 계산
        for (int i = 0; i < schedules.length; i++) {
            int workHopeTime = schedules[i] + 10;
            if (workHopeTime % 100 >= 60) {
                int hour = workHopeTime / 100 + 1;
                int min = workHopeTime % 10;

                workHopeTime = hour * 100 + min;
            }

            schedules[i] = workHopeTime;
        }

        int answer = schedules.length;

        // 상품 받을 직원 계산
        for (int i = 0; i < schedules.length; i++) {
            for (int j = 0; j < timelogs[i].length; j++) {
                int day = startday + j;

                if (day % 7 == 6 || day % 7 == 0)  continue;

                // 출근 허용시간 보다 출근시간이 크면 상품 받을 직원에서 제외
                if (schedules[i] < timelogs[i][j]) {
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }

    static void main() {
        int[] schedules = {730, 855, 700, 720};
        int[][] timelogs = {
                {710, 700, 650, 735, 700, 931, 912},
                {908, 901, 805, 815, 800, 831, 835},
                {705, 701, 702, 705, 710, 710, 711},
                {707, 731, 859, 913, 934, 931, 905}
        };
        int startday = 1;

        System.out.println(solution(schedules, timelogs, startday));
    }
}

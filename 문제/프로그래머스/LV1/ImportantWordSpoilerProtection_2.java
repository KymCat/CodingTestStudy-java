package 프로그래머스.LV1;

import java.util.HashSet;

/*
    2025 카카오 하반기 1차 - 중요한 단어를 스포 방지
    다른 사람 풀이 - 임석준 님 코드
 */
public class ImportantWordSpoilerProtection_2 {
    private static int solution(String message, int[][] spoiler_ranges) {
        StringBuilder blinds = new StringBuilder(message);
        for (int[] range : spoiler_ranges) {
            int start = range[0];
            int end = range[1];

            // spoiler 범위에 속해있는 공백제외 문자들 전부 '*' 로 블라인드 처리
            for (int i = start; i <= end; i++) {
                if (blinds.charAt(i) != ' ') {  // 공벡제외
                    blinds.setCharAt(i, '*');
                }
            }
        }

        // 중복제거와 빠른 조회를 위한 HashSet 사용
        // 공백 기준으로 단어를 하나씩 추출해서 HashSet에 저장
        HashSet<String> set = new HashSet<>();
        for (String word : blinds.toString().split(" "))
            set.add(word);

        // 원본 메세지를 공백기준으로 하나씩 추출
        // 추출한 word가 HashSet(set) 에 없으면 answer + 1
        //  > 해당 단어가 set에 없다는 것은 블라인드 처리당했다는 것이다.
        int answer = 0;
        for (String word : message.split(" ")) {
            if (!set.contains(word)) {
                answer++;
                set.add(word);
            }
        }

        return answer;
    }


    static void main() {
        //String message = "here is muzi here is a secret message";
        //int[][] spoiler_ranges = {{0,3}, {23,28}};

        String message = "my phone number is 01012345678 and may i have your phone number";
        int[][] spoiler_ranges = {{5, 5}, {25, 28}, {34, 40}, {53, 59}};

        System.out.println(solution(message, spoiler_ranges));
    }
}

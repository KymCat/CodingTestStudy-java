package 프로그래머스.LV1;

import java.util.*;

/*
    2025 카카오 하반기 1차 - 중요한 단어를 스포 방지
 */
public class ImportantWordSpoilerProtection {
    public static class WordInfo {
        String word;    // 단어
        int start;      // 시작 인덱스
        int end;        // 끝 인덱스

        public WordInfo(String word, int start, int end) {
            this.word = word;
            this.start = start;
            this.end = end;
        }
    }

    public static int solution(String message, int[][] spoiler_ranges) {
        List<WordInfo> wordInfos = createWordInfos(message);

        return importantWordExtract(wordInfos, spoiler_ranges);
    }

    // 단어 전체 정보 만들기
    public static List<WordInfo> createWordInfos(String message) {
        List<WordInfo> wordInfos = new ArrayList<>();

        int idx = 0;
        while(idx < message.length()) {
            if (message.charAt(idx) == ' ') {   // 문자열 첫 시작이 공백이면 컨티뉴
                idx++;
                continue;
            }

            int start = idx;

            while (idx < message.length() && message.charAt(idx) != ' ')    // end 계산
                idx++;
            int end = idx -1; // -1은 공백제거
            String word = message.substring(start, end + 1);

            WordInfo wordInfo = new WordInfo(word, start, end);

            wordInfos.add(wordInfo);
        }
        return wordInfos;
    }

    // 중요 단어 추출
    public static int importantWordExtract(List<WordInfo> wordInfos, int[][] spoiler_ranges) {
        Set<String> spoilerWords = new LinkedHashSet<>();
        Set<String> normalWords = new HashSet<>();

        for (WordInfo info : wordInfos) {
            boolean isSpoiler = false;

            for (int[] range : spoiler_ranges) {
                if (isSpoilerRange(info.start, info.end, range[0], range[1])) {
                    isSpoiler = true;
                    break;
                }
            }

            if (isSpoiler) {
                spoilerWords.add(info.word);
            } else {
                normalWords.add(info.word);
            }
        }

        int result = 0;

        for (String word : spoilerWords) {
            if (!normalWords.contains(word)) {
                result++;
            }
        }

        return result;
    }


    // 스포일러 범위에 속해있는지 검사
    public static boolean isSpoilerRange(int wordStart, int wordEnd, int rangeStart, int rangeEnd) {
        return wordStart <= rangeEnd && rangeStart <= wordEnd;
    }

    static void main() {
        //String message = "here is muzi here is a secret message";
        //int[][] spoiler_ranges = {{0,3}, {23,28}};

        String message = "my phone number is 01012345678 and may i have your phone number";
        int[][] spoiler_ranges = {{5, 5}, {25, 28}, {34, 40}, {53, 59}};

        System.out.println(solution(message, spoiler_ranges));
    }
}

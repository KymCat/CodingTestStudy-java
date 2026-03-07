package 열거형.기본;

import java.util.Arrays;

public class enumTest {
    public static void main(String[] args) {
        Week w = Week.FRIDAY;

        // Enum .name() ------------------- //
        String weekName = w.name();     // .name() : 열거 객체의 이름을 문자열로 반환
        System.out.println(weekName);   // FRIDAY


        // Enum .ordinal() ---------------- //
        int weekNum = w.ordinal();      // .ordinal() : 열거 객체의 순번(0부터 시작)을 반환
        System.out.println(weekNum);    // 4


        // Enum .compareTo() -------------- //
        Week w1 = Week.TUESDAY;     // 2
        Week w2 = Week.SATURDAY;    // 6

        int compare1 = w1.compareTo(w2);    // SATURDAY(w2) 기준으로 TUESDAY(w1) 위치
        System.out.println(compare1);       // -4

        int compare2 = w2.compareTo(w1);    // TUESDAY(w1) 기준으로 SATURDAY(w2) 위치
        System.out.println(compare2);       // 4


        // Enum .valueOf() ---------------- //
        Week w3 = Week.valueOf("SUNDAY");    // 문자열을 입력받아서 일치하는 열거 객체 반환
        System.out.println(w3);                     // SUNDAY


        // Enum .values() ----------------- //
        Week[] w4 = Week.values();                  // 모든 열거 객체들을 배열로 반환

        System.out.println(Arrays.toString(w4));    // [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]

        for (Week week : Week.values())             // 열거 순회
            System.out.println(week);

    }
}

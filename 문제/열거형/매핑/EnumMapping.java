package 열거형.매핑;

public class EnumMapping {
    public static void main(String[] args) {
        Season s = Season.SUMMER;

        System.out.println(s.name());       // SUMMER -> 열거 객체명 출력
        System.out.println(s.getSeason());  // 여름 -> 매핑된 열거 데이터 출력
    }
}

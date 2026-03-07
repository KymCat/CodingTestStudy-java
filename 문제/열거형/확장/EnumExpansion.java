package 열거형.확장;

public class EnumExpansion {
    public static void main(String[] args) {
        double x = 1.0;
        double y = 3.5;

        Operation op1 = Operation.PLUS;

        System.out.println(op1.name());      // PLUS
        System.out.println(op1.toString());  // +

        // Enum 확장 메소드 실행
        double result = op1.apply(x,y);
        System.out.println(result);         // 4.5

        // ------------------------------------------------------------------- //

        Operation op2 = Operation.MULTI;

        System.out.println(op2.name());     // MULTI
        System.out.println(op2.toString()); // *

        // Enum 확장 메소드 실행
        double result2 = op2.apply(x,y);
        System.out.println(result2);        // 3.5
    }
}

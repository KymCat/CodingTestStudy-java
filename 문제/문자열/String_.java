package 문자열;

public class String_ {
    public static void main(String[] args) {

        // 객체 저장
        String s1 = new String("Hello World");
        String s2 = new String("Hello World");

        System.out.println(s1 == s2); // false

        // 문자열 저장
        String s3 = "Hello World";
        String s4 = "Hello World";

        System.out.println(s3 == s4); // true
    }
}

package 문자열;

public class StringBuffer_ {
    public static void main(String[] args) {
        /**
         *  String 타입
         *  +, .concat() 을 통해 문자열 연산 가능
         *  하지만 인스턴스 증가로 인한 공간 낭비 및 속도 저하 발생
         */
        String s1 = "";
        s1 += "Hello ";
        s1 += "World";
        System.out.println(s1); // Hello World


        /**
         *  StringBuilder, StringBuffer 타입
         *  문자열 연산(추가, 변경)이 자주 발생하는 경우 추천되는 자료형
         *  문자열 버퍼를 따로 생성하여 문자열을 쉽게 추가 및 변경 가능 => 상대적으로 공간 절약 및 속도 상승
         */
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" World");
        System.out.println(sb.toString()); // Hello World
        System.out.println(sb.capacity()); // capacity() : 버퍼 크기(초기 16, 크기 초과해도 자동 증가)


        /**
         *  하지만 언제나 StringBuilder(BUffer)가 String 보다 좋진 않다.
         *  String의 + 연산은 내부적으로 "StringBuilder" 를 사용하여 문자열로 반환한다.
         */

        String a1 = "hello" + "world";
        //는 아래와 같다.
        String a2 = new StringBuilder("hello").append("world").toString();
        // StringBuilder를 통해 "hello" 문자열을 생성하고 "world"를 추가하고 toString()을 통해 String 객체로 변환하여 반환

        /**
         *  이렇게 본다면 + 연산과 StringBuilder 를 사용하는 것이 다를게 없어 보이지만
         *  문자열을 합치는 일이 많을 경우에는 반복마다 StringBuilder 객체를 생성하고 변수에 대입하는 것이라서 비효율적이다.
         *  따라서 반복이 많을 경우에는 StringBuilder 를 사용하는 것이 성능, 공간면에서 바람직하다.
         */


        /**
         *  StringBuilder vs StringBuffer 차이
         *  StringBuffer 는 멀티스레드 환경에서 안전하게 동작 => 메서드에서 synchronized 키워드를 사용
         *  따라서 웹이나 소켓환경과 같이 비동기로 동작하는 경우가 많을 때는 StringBuffer 를 사용하자.
         */
    }
}

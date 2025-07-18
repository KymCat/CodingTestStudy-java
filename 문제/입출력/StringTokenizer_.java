package 입출력;

import java.util.StringTokenizer;

public class StringTokenizer_ {
    public static void main(String[] args) {
        /*
            StringTokenizer(String str)
                전달된 매개변수 str을 공백문자로 분리

            StringTokenizer(String str, String delim)
                전달된 매개변수 str을 delim으로 분리

            StringTokenizer(String str, String delim, boolean returnDelims)
                전달된 매개변수 str을 delim으로 분리시키는데
                delim까지 토큰으로 포함시키는 여부를 returnDelims로 결정(true or false)

            .nextToken() : 다음 토큰 반환
            .countTokens() : 남아있는 token의 개수를 반환, nextToken() 할 때마다 count-1
            .hasMoreTokens() : 토큰이 남아있으면 true 없으면 false
         */

        String s1 = "Hello World";
        String s2 = "Hello,World";

        StringTokenizer st1 = new StringTokenizer(s1);
        System.out.println(st1.countTokens()); // 2
        while (st1.hasMoreTokens())
            System.out.print(st1.nextToken() + " ");
            // Hello World => Hello World
        System.out.println("\n" + st1.countTokens()); // 0

        StringTokenizer st2 = new StringTokenizer(s2,",");
        while (st2.hasMoreTokens())
            System.out.print(st2.nextToken() + " ");
            // Hello,World => Hello World

        System.out.println();
        StringTokenizer st3 = new StringTokenizer(s2,",", true);
        while (st3.hasMoreTokens())
            System.out.print(st3.nextToken() + " ");
        // Hello,World => Hello,World ( ',' 도 토큰으로 포함 )
    }
}

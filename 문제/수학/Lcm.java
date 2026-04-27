package 수학;

/*
    최소 공배수(LCM) : 두 수 이상의 수들의 공통인 배수 중 가장 작은 배수
    각 수의 소인수들 중에서 지수가 가장 높은 수들의 곱셈

    공식 : lcm(a,b) = abs(ab) / gcd(a,b)
    3가지 이상의 수 최소공배수 공식 : lcm(lcm(a,b),c)
 */
public class Lcm {
    protected static int gcd(int a, int b) {
        while(b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }

    protected static int lcm(int a, int b) {
        return Math.abs(a / gcd(a,b) * b);  // b 를 나중에 곱해서 오버플로우 방지
    }

    static void main() {
        System.out.println(lcm(10,12)); // 10, 12의 최소공배수 = 60
        System.out.println(lcm(lcm(12,20),36)); // 12, 20, 36의 최소공배수 = 180
    }
}

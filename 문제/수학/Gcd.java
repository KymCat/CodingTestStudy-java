package 수학;

/*
    최대 공약수(GCD) : 두 수 이상의 여러수의 공약수 중 `최대 수`
    공통으로 존재하는 소인 수 중에서 `최소 지수` 들을 선택해 곱하면 최대 공약수
 */
public class Gcd {
    public static int gcd(int a, int b) {
        // 유클리드 호제법 최대 공약수
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }

    static void main() {
        System.out.println(gcd(12, 18));
    }
}

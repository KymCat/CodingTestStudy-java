package 백준.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 서비스 종료로 인해 해당 풀이가 틀릴 수 도 있습니다.
public class G9663 {
    static int n;
    static int[] queen;
    static int answer;

    /*
        queen 배열에 관해
            idx         -> 체스판의 행
            queen[idx]  -> 체스판의 열

        퀸의 이동(공격)방식 때문에 어차피 같은 행에는 퀸을 2개 이상 놓을 수 없다.
        1차원 배열로 만들어서 인덱스 값을 행으로, 배열 안에 value 들을 열로 놓으면 간단하게
        배치 할 수 있는지 계산 할 수 있다.
     */

    // (row, col) 위치에 퀸 배치 가능 여부
    static public boolean canPlace(int row, int col) {
        for (int i = 0; i < row; i++) {

            /*
                기본적으로 퀸은 같은 행과 열, 대각선으로 공격 가능
                queen[i] == col     : 같은 열에 배치 되는지
                Math.abs(i - row) == Math.abs(queen[i] - col)   : 대각선에 배치 되는지
             */
            if (queen[i] == col || Math.abs(i - row) == Math.abs(queen[i] - col))
                return false;
        }

        return true;
    }

    static public void solution(int row) {
        if (row == n) { // 모든 행을 채웠다면 경우의 수 + 1
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (canPlace(row, i)) {
                queen[row] = i;
                solution(row + 1);  // 다음 행 퀸 배치자리 계산(재귀)
            }
        }

    }

    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queen = new int[n];
        answer = 0;

        solution(0);
        System.out.println(answer);
    }
}

package 백준.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 서비스 종료로 인해 해당 풀이가 틀릴 수 도 있습니다.
public class G17136 {
    /*
        paper           : 입력받은 종이 맵
        coloredPaper    : 색종이
        result          : 필요한 최소 색종이 갯수 저장 변수
     */
    static int[][] paper = new int[10][10];
    static int[] coloredPaper = { 0, 5, 5, 5, 5, 5 };
    static int result = Integer.MAX_VALUE;

    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);
        if (result == Integer.MAX_VALUE)
            System.out.println(-1);
        else System.out.println(result);
    }

    /**
     * 구현 로직 메서드 (백트랙킹)
     *
     * @param xy    : 좌표
     * @param cnt   : 지금까지 사용한 색종이 수
     */
    static void backtracking(int xy, int cnt) {
        if (xy == 100) {
            result = Math.min(cnt, result);
            return;
        }

        int row = xy / 10;
        int col = xy % 10;

        // 최소 갯수 보다 같거나 커져버리면 가지치기
        if (result <= cnt) return;

        // 제일 큰 색종이 (5x5) 부터 시작
        if (paper[row][col] == 1) {
            for (int i = 5; i > 0; i--) {
                if (coloredPaper[i] > 0 && checked(row, col, i)) {
                    coloredPaper[i]--;
                    fillColoredPaper(row, col, i, 0);

                    backtracking(xy + 1, cnt + 1);

                    coloredPaper[i]++;
                    fillColoredPaper(row, col, i, 1);
                }
            }
        }
        else
            backtracking(xy + 1, cnt);
    }

    /**
     * 종이에 색종이를 붙이거나 떼는 메서드
     *
     * @param row   : 행
     * @param col   : 열
     * @param size  : 색종이 사이즈
     * @param value : 1은 색종이 떼어내기, 0은 색종이 붙이기
     */
    private static void fillColoredPaper(int row, int col, int size, int value) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                paper[i][j] = value;
            }
        }
    }

    /**
     * 해당 size 색종이를 붙일 수 있는지 검사하는 메서드
     *
     * @param row   : 행
     * @param col   : 열
     * @param size  : 색종이 사이즈
     * @return      : 색종이를 붙일 수 있으면 true, 없으면 false
     */
    static boolean checked(int row, int col, int size) {
        // 범위 검사
        if (row + size > 10 || col + size > 10)
            return false;

        // 색종이 범위가 1인지 검사
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != 1) return false;
            }
        }

        return true;
    }
}

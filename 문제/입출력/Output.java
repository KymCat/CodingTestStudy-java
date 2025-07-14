package 입출력;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Output {
    public static void main(String[] args) throws IOException {
        /*
            적은 양의 출력에서는 sout의 편리
            많은 양의 출력은 BufferedWriter가 유리
         */
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "Hello world";

        bw.write(str);
        bw.newLine(); // 줄바꿈
        bw.flush(); // 남아 있는 데이터 모두 출력
        bw.close();

        /*
            BufferedWriter는 버퍼를 잡아 놓은 것
            때문에 반드시 사용 후에 flush() / close()를 해주어야한다.
         */
    }
}

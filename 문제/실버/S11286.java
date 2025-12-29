package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 우선순위 큐 정렬 기준 재정의
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) ->{
           int obs_o1 = Math.abs(o1);
           int obs_o2 = Math.abs(o2);

           if(obs_o1 == obs_o2) return o1 > o2 ? 1 : -1;
           else return obs_o1 - obs_o2;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (queue.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(queue.poll()).append('\n');
            }
            else
                queue.add(x);
        }

        System.out.println(sb);
    }
}

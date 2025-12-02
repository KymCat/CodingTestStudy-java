package 정렬;

import java.util.ArrayList;

public class ComparableMain {
    public static void main(String[] args) {
        ArrayList<Score> arr = new ArrayList<>();
        arr.add(new Score(80,100));
        arr.add(new Score(100,50));
        arr.add(new Score(70,100));
        arr.add(new Score(80,90));

        // 영어점수가 같으면 수학점수로 비교후 내림차순
        arr.sort(null); // null : 구현한 compareTo() 기준으로 정렬
        // arr.sort(Comparator.reverseOrder()); // 반대 정렬
        for (Score s : arr)
            System.out.println(s.toString());
    }
}

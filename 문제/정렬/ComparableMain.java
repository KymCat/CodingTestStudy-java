package 정렬;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparableMain {
    public static void main(String[] args) {
        ArrayList<ScoreComparable> arr = new ArrayList<>();
        arr.add(new ScoreComparable(80,100));
        arr.add(new ScoreComparable(100,50));
        arr.add(new ScoreComparable(70,100));
        arr.add(new ScoreComparable(80,90));

        // 영어점수가 같으면 수학점수로 비교후 내림차순
        arr.sort(null); // null : 구현한 compareTo() 기준으로 정렬
        // arr.sort(Comparator.reverseOrder()); // 반대 정렬
        for (ScoreComparable s : arr)
            System.out.println(s.toString());
    }
}

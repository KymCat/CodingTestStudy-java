package 정렬;

import java.util.ArrayList;

public class ComparatorMain {
    public static void main(String[] args) {
        ArrayList<Score> arr = new ArrayList<>();
        arr.add(new Score(80,100));
        arr.add(new Score(100,50));
        arr.add(new Score(70,100));
        arr.add(new Score(80,90));

        arr.sort(new ScoreComparator());
        for (Score s : arr)
            System.out.println(s.toString());
    }
}

package 정렬;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score> {

    @Override
    public int compare(Score o1, Score o2) {
        // 오름차순
        if (o1.english == o2.english) return o1.math - o2.english;
        return o1.english - o2.english;
    }
}

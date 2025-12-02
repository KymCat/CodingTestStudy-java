package 정렬;

public class ScoreComparable implements Comparable<ScoreComparable>{
    int english;
    int math;

    public ScoreComparable(int english, int math) {
        this.english = english;
        this.math = math;
    }

    @Override
    public String toString() {
        return "ScoreComparable{" +
                "english=" + english +
                ", math=" + math +
                '}';
    }

    @Override
    public int compareTo(ScoreComparable o) {
        // 내림차순 = o - this
        // 오름차순 = this - o

        // 아래 코드는 내림차순 구현
        if(this.english == o.english) return o.math - this.math;
        return o.english - this.english;
    }
}

package Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        List<Member> members = new ArrayList<>();
        members.add(new Member("Minsu",25, 60, true));
        members.add(new Member("Minji",24, 45, false));
        members.add(new Member("Mansu",30, 75, true));
        members.add(new Member("Yougmi",24, 42, false));

        /*
            Java 8부터 추가된 Stream
            for, while 등을 이용하던 기존의 반복을 대체할 수 있다.
         */

        // 나이만 출력
        List<Integer> ages = members.stream()
                .map(Member::getAge)
                .toList();
                // toList()는 불변,
                // 수정 가능한 리스트를 얻고 싶을 경우 : .collect(Collectors.toList())

        System.out.println(ages); // [25, 24, 30, 24]

        // 남자만 출력
        List<String> men = members.stream()
                .filter(Member::isSex) // 남자만
                .map(Member::getName)
                .toList();

        System.out.println(men); // [Minsu, Mansu]

        // 나이 오름차순 정렬, 같으면 몸무게 오름차순으로 정렬
        List<String> sorted = members.stream()
                .sorted(Comparator.comparing(Member::getAge)
                        .thenComparing(Member::getWeight))
                .map(Member::getName)
                .toList();

        System.out.println(sorted); // [Yougmi, Minji, Minsu, Mansu]

    }
}

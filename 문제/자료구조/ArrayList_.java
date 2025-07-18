package 자료구조;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayList_ {

    /*
        -->>  List<Integer> list = new ArrayList<>()  <<--

        List는 인터페이스
        new ArrayList는 List를 구현한 클래스

        ArrayList 특징
        - 리스트의 길이가 가변적, 즉 "동적 할당"
        - 배열과 달리 메모리에 연속적으로 나열되어있지 않고 주소로 연결되어 있는 형태 ( 상대적으로 배열보다 접근속도가 느림 )
        - 데이터 사이에 빈 공간을 허용하지 않음
        - 객체로 데이터를 다루기 때문에 상대적으로 배열보다 메모리가 차지 비율이 큼
        - 데이터 중간 삽입 시, 요소들의 위치를 앞뒤로 자동 이동 시키기에 느림
        - 조회를 많이 하는 경우에 사용하는 것이 권장

        ArrayList 수용량
            - 내부적으로 크기 10인 배열을 생성
            - 실제 size() 는 0
            - 요소를 10개 이상 추가 시, 자동으로 배열을 더 크게 할당 (1.5배씩)
            - 따라서 초기 수용량 설정이 중요함 (최악 O(n^2))
     */

    static List<Integer> list = new ArrayList<>(); // 초기 수용량 10
    static List<Integer> list2 = new ArrayList<>(20); // 초기 수용량 20

    public static void main(String[] args) {
        // 데이터(요소) 추가
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list); // [10,20,30]


        // 데이터(요소) 제거
        list.remove(1);
        System.out.println(list); // [10,30]


        // 데이터(요소) 전부 제거
        list.clear();
        System.out.println(list); // []


        // 공통된 데이터(요소) 제거
        list2.add(10);
        list2.add(20); // 공통
        list2.add(20); // 공통
        list2.add(30);
        list2.add(40);

        list2.removeAll(List.of(20)); // 매개변수 : Collection타입
        System.out.println(list2); // [10,30,40]

        // 공통된 데이터(요소)만 남기기
        list.add(10);
        list.add(20); // 공통
        list.add(20); // 공통
        list.add(30);
        list.add(40);

        list.retainAll(List.of(20)); // 매개변수 : Collection타입
        System.out.println(list); // [20,20]

        // 요소검색
        list.clear();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(10);
        // [10,20,30,40,10] 리스트

        // list가 비어 있는지 확인
        System.out.println(list.isEmpty()); // false

        // list에 50 데이터가 있는지 확인
        System.out.println(list.contains(50)); // false

        // list에 10 데이터가 있는 위치 반환
        System.out.println(list.indexOf(10)); // 0

        // list에 10 데이터가 있는 마지막 위치 반환
        System.out.println(list.lastIndexOf(10)); // 4

        // list의 인덱스 1번의 데이터 얻기
        System.out.println(list.get(1)); // 20

        // list 슬라이스, 2 ~ 4 인덱스 범위 데이터 얻기
        System.out.println(list.subList(2,5)); // [30,40,10]

        // 데이터(요소) 변경
        list.set(4, 50); // 인덱스 4번의 값 50으로 변경 10 --> 50
        System.out.println(list); // [10,20,30,40,50]


        // 데이터(요소) 정렬 : 원본 배열을 바꿈
        list2.clear();
        list2.add(20);
        list2.add(10);
        list2.add(50);
        list2.add(40);
        list2.add(30);

        // 오름차순
        list2.sort(Comparator.naturalOrder());
        System.out.println(list2);

        // 내림차순
        list2.sort(Comparator.reverseOrder());
        System.out.println(list2);

    }
}

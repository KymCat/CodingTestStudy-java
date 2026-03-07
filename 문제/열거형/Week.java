package 열거형;

public enum Week {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

/*
*   상수를 객체지향적으로 관리하기 위한 타입
*   Java 에서 interface 와 같이 `독립된 특수 클래스` 로 구분한다
*   따라서 reference Type 이므로 heap 영역에 저장되고 변수는 메모리 주소를 가리키게 된다
*
*   enum 각 상수들은 별개의 메모리 주소값에 저장되어 각 같은 값을 비교 시, 동일하다는 결과가 출력된다.
*
* */

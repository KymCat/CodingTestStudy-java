# 🔤 문자열
### 1️⃣ String 변수 타입
자바의 변수는 기본형과 참조형 타입으로 나뉘며 기본형은 실제값이 변수에 저장되며 스택에서 데이터를 관리하고
참조형은 객체의 주소(참조값)가 변수에 저장되며 힙에서 관리한다.  
  
우리가 문자열 타입이라고 부르는 String은 클래스이고 기본형이 아니지만 값을 가질 수 있고 참조형 변수이다.

##
### 2️⃣ 변수 선언 방법
- ***객체 저장***
    ```java
    String s1 = new String("Hello World");
    String s2 = new String("Hello World");

    System.out.println(s1 == s2); // false
    ```
    `new`연사자를 이용하여 객체를 생성하여 문자열을 할당하면 s1,s2 변수에는 참조값이 저장되고
    각 변수들은 인스턴스를 따로 생성했기 떄문에 비교시 false 가 출력된다.    
         
    하지만 `.equals()`로 비교하면 true가 출력된다.
  
- ***문자열 저장***
    ```java
    String s3 = "Hello World";
    String s4 = "Hello World";

    System.out.println(s3 == s4); // true
    ```
    문자열 리터럴 값을 그대로 저장하게 되면 힙영역의 String Pool 에서 문자열을 생성하고 그 참조값을 연결해 준다.
    하지만 문자열은 다시 재사용할 가능성이 높기 때문에 중복된 값은 이미 생성된 문자열의 참조값을 연결해 주기에
    s3, s4의 비교값이 true가 나오게 되는 것이다.

##
### 3️⃣ String의 불변성
- ***불변성***  
    String 객체는 한번 생성된 후 변경할 수 없다. 값을 다시 할당하면 새로운 객체가 생성된다.
  
- ***불변성으로 설계된 이유***
  1. 안정성 및 스레드 안정성  
    불변 객체는 한 번 생성되면 상태가 변경되지 않기 때문에, 여러 스레드가 동시에 접근하더라도 상태가 변하지 않아 안전하다. 
    이는 멀티스레딩 환경에서 동기화 문제를 최소화한다.
  
  2. 캐싱 및 성능 최적화  
    자바의 String은 문자열 리터럴을 캐싱하는 String Pool을 사용한다. 동일한 문자열 리터럴은 메모리에 하나의 객체만
    생성되고 재사용된다. 때문에 같은 문자열에 대한 여러 참조를 안전하게 공유 가능하다.
  
  3. 보안  
    문자열은 비밀번호, 사용자 정보, 네트워크 정보 등 중요한 정보를 저장하는데 사용되기에 불변성은 이러한 데이터가
    의도치 않게 변경되는 것을 막아준다.

##
### 4️⃣ StringBuilder / StringBuffer
StringBuilder, StringBuffer 는 문자열을 다룬다는 점에서 String 과 같지만 String 의 특징인 불변성과는 달리
내부 버퍼에 문자열을 저장해두고 그 안에서 추가, 수정, 삭제 작업할 수 있게 가변적이다.  
  
이러한 특징 때문에 StringBuilder, StringBuffer 는 `.append()`, `.delete()` 등을 이용하여 동일 객체 내에서
문자열을 변경하는 것이 가능하다.

- ***메모리 관점에서의 차이점***  
  ```java
  String star = "*";
      
  for ( int i = 1; i < 10; i++ ) {
  star += "*";
  }
  ```
  ```java
  StringBuffer sb= new StringBuffer("*");
  sb.append("*********");
  ```
  ![memory](https://github.com/user-attachments/assets/915940af-eb0f-4c58-9d3d-a7d16f50b8de)  
  
  String 객체에서 문자열이 반복적으로 추가 될 때마다 새로운 객체가 생성되고 참조값이 변경되므로 메모리에서
  참조되지 않은 객체들이 쌓이게 되고 결국 FULL GC를 일으킬 수 있는 원인이 된다.  
    
  반면 StringBuffer 는 메모리 블럭을 가변적으로 활용할 수 있기 때문에 효율적으로 문자열을 다룰 수 있다.
    
- ***문자열 합치기 성능***  
  문자열을 합치기 위해서 자바에서는 `+` 기호를 지원한다. 하지만 위에 봤듯이 String 에서의 문자열 변경은
  새로운 객체를 만들어서 이를 반복하면 메모리가 낭비된다는 결과를 가져오기에 `+` 기호 보다는 StringBuffer,
  StringBuilder 의 `appned()` 메서드를 사용하는게 무조건 좋아 보인다.  
    
  하지만 이는 반은 맞고 반을 틀린 말이다.    
    
  ![concat](https://github.com/user-attachments/assets/c3d1d6ed-d735-47ca-96a2-be3b722200ee)  
  자바는 문자열 `+` 연산에 컴파일 전 내부적으로 StringBuilder 클래스를 만든 후 다시 문자열로 반환한다.
  ```java
  String a = "hello" + "world";
  /* 는 아래와 같다. */
  String a = new StringBuilder("hello").append("world").toString();
  // StringBuilder를 통해 "hello" 문자열을 생성하고 "world"를 추가하고 toString()을 통해 String 객체로 변환하여 반환
  ```
  그러면 `+` 연산을 적극적으로 사용해도 문제가 정말 없는 것 일까? 안타깝게도 위 코드를 보면 결국 `new StringBuilder`로
  새로운 객체를 생성하고 다시 변수에 대입하는 비효율적인 행동을 하기에 반복적인 문자열 연산이 필요할 땐 처음부터
  StringBuilder, StringBuffer 객체로 생성하여 처리하는 것이 효율적이다.
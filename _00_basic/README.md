#String / StringBuilder / StringBuffer 

1. String 은 Immutable 하므로 변하지 않는 문자열은 상수로 선언하여 사용하면 좋다. 하지만 문자열 수정,삭제,추가 등은 heap 에 가비지가 많이 생길수 있다. Imutable 때문에 새로운 문자열은 새로운 메모리를 할당 받아 새로운 인스턴스가 생겨나고, 기존 문자열은 가비지 대상이 되게 된다. 
2. String을 Mutable 하게 사용하기 위해, StringBuilder 와 StringBuffer를 사용하면, 문자열 추가시 기존 문자열에 새로운 문자열이 더해지면서 덮어쓰기가 된다. 때문에 수정,삭제,추가등시 성능면에서 String 보다 훨씬 좋다. 
3.  StringBuilder 와 StringBuffer 의 차이는 Thread safe 여부이다. StringBuilder 는 동기화가 지원되지 않고 StringBuffer 는 동기화가 지원되므로 멀티쓰레드 환경에서는 StringBuffer 를 사용하면 된다.  

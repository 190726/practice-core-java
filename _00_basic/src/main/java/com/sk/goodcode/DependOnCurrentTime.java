package com.sk.goodcode;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 코드상에 제어 할수 없는 부분에 의존하는 부분이 있다면, 테스트가 어려워진다. 
 * 제어할수 없는 부분을 분리할 수 있는 방법을 생각해보자.
 *
 */
public class DependOnCurrentTime {
	
	//[[Step1]]
	// 현재날짜를 가져와서 일요일이면 서비스 폐쇄
	// 아래 코드는 일요일에 close 되는 테스트를 하려면, 일요일에 테스트를 해야만 통과한다. 
	// 날짜를 제어할 수 없기 때문에 테스트에 제약이 따른다.
	static void holidayClosed() {
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		if(dayOfWeek==DayOfWeek.SUNDAY) {
			System.out.println("close");
		}else {
			System.out.println("open");
		}
	}
	
	//[[Step2]]
	// 아래와 같이 LocalDate 를 파라미터로 넣어주면, 테스트는 가능하지만 매번 직접 설정해야만 하는 번거로움이 있다.
	static void holidayClosedForTest(LocalDate localDate) {
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		if(dayOfWeek==DayOfWeek.SUNDAY) {
			System.out.println("close");
		}else {
			System.out.println("open");
		}
	}
	
	//[[Step3]]
	// 동일한 이름의 arguments가 없는 메서드를 호출하면 LocalDate.now()를 인자를 갖도록 하는 메소드를 만들면,
	// holidayClosed 테스트시, 인자를 제어할 수 있게 된다.
	static void holidayClosedForTest() {
		holidayClosedForTest(LocalDate.now());
	}
	
	public static void main(String[] args) {
		
		holidayClosed();
		holidayClosedForTest(LocalDate.of(2023, 03, 26));
		holidayClosedForTest();
	}

}

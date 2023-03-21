package com.sk.practice.order;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ObjectOrderTest {
	
	/*
	 * collection 정렬은 다양한 방법이 있지만, 중요한 것은, Comparable 인터페이스의 구현체이어야 한다는 것이다. 
	 * 그렇지 않으면 Comparator 를 이용한다. 
	 */
	
	public static void main(String[] args) {
		List<Name> names = Arrays.asList(new Name("김기현"), new Name("강태우"), new Name("임지연"), new Name("박연진") );
		List<NameComparable> namesComparable = Arrays.asList(new NameComparable("김기현"), new NameComparable("강태우"), new NameComparable("임지연"), new NameComparable("박연진") );
		//Collections.sort를 이용한다. 
		//Collections.sort(namesComparable);
		System.out.println(namesComparable);
		
		//배열을 이용한 객체 정렬
		NameComparable[] array = namesComparable.toArray(new NameComparable[0]);
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		//나이순, 이름순
		//TreeSet 을 이용한 객체 정렬
		Set<NameComparable> sortSet = new TreeSet<>(namesComparable);
		System.out.println(sortSet);
		
		//Queue를 사용한 정렬
		PriorityQueue<NameComparable> queue = new PriorityQueue<>();
		queue.addAll(namesComparable);
		System.out.println(queue);

		//객체마다 Comparable 을 구현하는 것은 번거로울 수 있다. Comparator를 활용한다. 
		//1단계 : Comparator 익명 클래스 생성
		Comparator<Name> nameComparator = new Comparator<Name>() {
			@Override
			public int compare(Name o1, Name o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		names.sort(nameComparator);
		
		//2단계 : 람다
		names.sort((Name o1, Name o2) -> o1.getName().compareTo(o2.getName()));
		//3단계 : 파라미터 추론
		names.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		//4단계 : Comparator.comparing 사용
		names.sort(Comparator.comparing((Name o) -> o.getName()));
		//4단계 : Comparator.comparing 사용시 메서드 레퍼런스 적용
		names.sort(Comparator.comparing(Name::getName));
		
		
		System.out.println(names);
		
		
	}
	
	@Getter @Setter @AllArgsConstructor @ToString
	static class Name{
		private String name;
	}
	
	@Getter @Setter @AllArgsConstructor @ToString
	static class NameComparable implements Comparable<NameComparable>{
		
		private String name;
		
		@Override
		public int compareTo(NameComparable o) {
			return this.name.compareTo(o.getName()) > 0 ? 1: -1;
		}
	}
}

package com.sk.practice.interfaces;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.sk.practice.model.Person;

class SetInterfaceTest {

	@Test
	void _문자열배열_요소의_중복없애기() {
		String[] samples = stub();
		//1. 중복되는 요소를 제거하기
		Set<String> uniques = new HashSet<>();
		Set<String> dups = new HashSet<>();
		
		for(String str : samples)
			if(!uniques.add(str)) dups.add(str);
		
		uniques.removeAll(dups);
		assertEquals(uniques.size(), 2);
	}
	
	@Test
	void _문자열배열_요소의_중복없애기2() {
		Set<String> result = Arrays.stream(stub()).collect(Collectors.toSet());
		assertEquals(result.size(), 3);
	}
	
	@Test
	void _문자열배열_요소의_중복없애기3() {
		List<String> lists = Arrays.asList(stub());
		Set<String> removeDups = SetInterface.removeDups(lists);
		assertEquals(removeDups.size(), 3);
	}
	
	@Test
	void _TreeSet을이용한_객체정렬() throws Exception {
		
		//불변리스트는 List의 sort 메서드 사용이 불가하다.
		List<Person> persons = new ArrayList<>(persons());
//		persons.add(new Person(10, "홍길동"));
//		persons.add(new Person(20, "이순신"));
//		persons.add(new Person(14, "김구"));
//		persons.add(new Person(10, "군길동"));
		
		persons.sort((o1, o2) ->{
			return o1.getAge() > o2.getAge() ? -1 : 1;
		});
		
		System.out.println(persons);
		
		//불변리스트는 스트림을 이용하여 정렬 가능하다.
		persons().stream().sorted((o1, o2) ->{
			return o1.getAge() > o2.getAge() ? -1 : 1;
		}).forEach(System.out::println);;
		
		//배열을 이용한 객체 정렬
		Person[] array = persons().toArray(new Person[0]);
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		//나이순, 이름순
		//TreeSet 을 이용한 객체 정렬
		Set<Person> sortSet = new TreeSet<>(persons());
		System.out.println(sortSet);
		
		//Queue를 사용한 정렬
		PriorityQueue<Person> queue = new PriorityQueue<>();
		queue.addAll(persons());
		System.out.println(queue);
	}
	
	private static String[] stub() {
		return new String[]{"lee","kimm","lee","pak"};
	}
	
	private static List<Person> persons(){
		return List.of(
				new Person(10, "홍길동"),
				new Person(20, "이순신"),
				new Person(14, "김구"),
				new Person(10, "군길동")
				);
	}
}
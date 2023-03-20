package com.sk.practice.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sk.practice.model.Person;

public class ListInterfaceTest {
	
	@Test
	void listShuffle() throws Exception {
		
		List<Integer> list = List.of(1, 2, 3, 4, 5);
		List<Integer> nums = new ArrayList<>(list);
		ListInterface.shuffle(nums);
		System.out.println(nums);
		
		//Collections에서 제공하는 메서드 사용
		Collections.shuffle(nums);
		System.out.println(nums);
	}
	
	@Test
	void iterator() throws Exception {
		for(Iterator<Person> it = persons().iterator();it.hasNext();) {
			System.out.println(it.next());
		}
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

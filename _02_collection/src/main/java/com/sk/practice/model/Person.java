package com.sk.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements Comparable<Person>{
	
	private int age;
	private String name;
	
	/*
	 * 나이순 > 이름순
	 */
	@Override
	public int compareTo(Person o) {
		
		if(this.age > o.getAge()) return 1;
		else if(this.age == o.getAge())
			return this.name.compareTo(o.getName());
		else return -1;
	}
	
}
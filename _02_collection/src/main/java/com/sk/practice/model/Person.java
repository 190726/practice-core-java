package com.sk.practice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements Comparable<Person>{
	
	private int age;
	private String name;
	private Party party;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
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
	
	public static List<Person> stub(){
		return List.of(
				new Person(43, "이상국", new Party(1, "인사팀")),
				new Person(39, "유명석", new Party(1, "인사팀")),
				new Person(29, "김재은", new Party(1, "인사팀")),
				new Person(31, "이지현", new Party(2, "회계팀")),
				new Person(27, "신제원", new Party(2, "회계팀")),
				new Person(32, "이우석", new Party(3, "총무팀")),
				new Person(35, "박보람", new Party(3, "총무팀"))
				);
	}
}
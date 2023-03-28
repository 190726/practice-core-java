package com.sk.practice.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.sk.practice.model.Person;

/*
 * 일급 컬렉션
 * 1. 비지니스에 종속적인 자료구조
 * 2. Collection의 불변성을 보장
 * 3. 상태와 행위를 한곳에서 관리
 * 4. 이름이 있는 컬렉션
 */

public enum CustomCollection {
	
	INSTANCE;
	
	private final Map<UUID, Person> persistenceMap = new ConcurrentHashMap<>();

	//id가 없으면, id생성후, 등록 / id가 있으면 해당 id로 person 이 있다면, update하고 없으면 save
	public void save(Person p) {
		if(p.getId() == null)
			p.setId(UUID.randomUUID());
		if(persistenceMap.put(p.getId(), p)!=null)
			persistenceMap.compute(p.getId(), (UUID k, Person v) -> p);
	}
	
	public List<Person> personAll(){
		return new ArrayList<>(persistenceMap.values());
	}
	
	public static void main(String[] args) {
		CustomCollection c = CustomCollection.INSTANCE;
		Person p = new Person(10, "옛날이름");
		c.save(p);
		System.out.println(c.personAll());
		p.setAge(11);
		p.setName("신이름");
		c.save(p);
		System.out.println(c.personAll());
	}
}

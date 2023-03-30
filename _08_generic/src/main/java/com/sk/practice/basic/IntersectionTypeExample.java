package com.sk.practice.basic;

import java.util.function.Consumer;

public class IntersectionTypeExample {
	
	interface DelegateTo<T>{
		T delegate();
	}
	
	interface Hello extends DelegateTo<String>{
		default void hello() {
			System.out.println("hello" + delegate());
		}
	}
	
	interface Printer extends DelegateTo<String>{
		default void print() {
			System.out.println("print" + delegate().toUpperCase());
		}
	}
	
	public static void main(String[] args) {
		
		//() -> "hello" 가 T 타입이 되고, Consumer 인자의 타입은 자동으로 T가 되게 된다.T 타입이므로, hello() 와 print() 메소드 호출이 가능하다.
		hello((DelegateTo<String> & Hello & Printer) () -> "hello", t ->{
			t.hello();
			t.print();
		});
	}

	private static <T extends DelegateTo<S>, S> void hello(T t, Consumer<T> consumer) {
		consumer.accept(t);
	}

}

package com.sk.practice.basic;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class IntersectionTypeExample2 {
	
	//1. 인터페이스를 정의한다.
	static interface Cart<T>{
		T product();
		void product(T t);
	}
	
	//2.인터페이스를 implements 한다. 
	static class OnlineCart implements Cart<Product>{
		
		private Product product;

		@Override
		public Product product() {
			return this.product;
		}

		@Override
		public void product(Product t) {
			this.product = t;
		}
	}
	
	//3.인터페이스의 타입파라미터 class 를 만든다. 
	static class Product{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Product(String name) {
			super();
			this.name = name;
		}

		@Override
		public String toString() {
			return "Product [name=" + name + "]";
		}
	}
	
	//4. Supplier & Cart를 확장한 인터페이스를 선언한다.
	//  Cart 인터페이스는 오바라이드하고, Supplier는 그대로 둔다. Forwarding 인터페이스는 하나의 추상메서드만 갖는 Functional interface 가 된다.
	interface Forwarding<T> extends Supplier<Cart<T>>, Cart<T>{

		@Override
		default T product() {
			return get().product();
		}

		@Override
		default void product(T t) {
			get().product(t);
		}
	}
	
	//5. 기능이 추가될 인터페이스를 추가한다. 추가기능은 default 로 구현한다. 
	static interface decorate<T> extends Supplier<Cart<T>>{
		
		default <R> R appendTag(Function<T, R> mapper) {
			System.out.println("---> decor!!!");
			return mapper.apply(get().product());
		}
	}
	
	private static <T extends Supplier<S>, S> void run(T t, Consumer<T> consumer){
		consumer.accept(t);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Product product = new Product("상품명");
		Cart<Product> cart = new OnlineCart();
		cart.product(product);
		
		run((Forwarding<Product> & decorate<Product>)() -> cart, o->{
			System.out.println(o.product());
			String name = o.appendTag(p -> p.getName());
			System.out.println(name);
		});
		
	}
}

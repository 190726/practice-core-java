package com.sk.basic.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalTest {
	
	public static void main(String[] args) {
		var num1 = 12;
		var num2 = 1.9;
		
		//java 에서 float 과 double 은 부동소수점(소수점이 고정되지 않는 방식) 방식이다. 자세한내용은 고정소수점/부동소수점 구글링해볼것.
		//부동소수점은 연산시, 근사값으로 처리 되는 부분이 있어 오차가 발생할 수 있다.
		System.out.println(num1 * num2);//22.799999999999997
		
		//실수 연산은 BigDecimal 을 사용할것.
		
		//잘못된 방식
		BigDecimal big1 = new BigDecimal(12);
		BigDecimal big2 = new BigDecimal(1.9);//잘못된 방식
		System.out.println(big2);
		//1.899999999999999911182158029987476766109466552734375
		System.out.println(big1.multiply(big2));
		//22.799999999999998934185896359849721193313598632812500
		
		//옮은 방식1
		BigDecimal big3 = new BigDecimal("12");
		BigDecimal big4 = new BigDecimal("1.9");
		System.out.println(big3.multiply(big4));
		
		//옮은 방식1
		BigDecimal big5 = BigDecimal.valueOf(12);
		BigDecimal big6 = BigDecimal.valueOf(1.9);
		System.out.println(big5.multiply(big6));
	}
}
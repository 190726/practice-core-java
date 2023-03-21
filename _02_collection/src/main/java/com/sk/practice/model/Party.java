package com.sk.practice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Party {
	
	private int code;
	private String partyName;
	
	public static List<Party> stub(){
		return List.of(new Party(1, "인사팀"),
				new Party(2, "회계팀"),
				new Party(3, "경영팀"),
				new Party(4, "전략팀"),
				new Party(5, "홍보팀"),
				new Party(6, "상품팀"),
				new Party(8, "개발팀"));
	}
}
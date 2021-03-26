package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	// Criteria 클래스의 용도는 pageNum과 amount 값을 같이 전달하는 용도지만 생성자를 통해서 기본값을 1페이지 10개로 지정한다.
	// 페이징 처리를 위해서는 pageNum과 amount가 필요하다.
	
	private int pageNum;
	private int amount;
	
	
	// 검색 기능을 만들기 위해서 2가지 변수를 추가한다.
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10);
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	
	// 검색 조건이 각 글자(T, W, C)로 구성되어 있으므로 검색 족너을 배열로 만들어서 한 번에 처리하기 위함이다
	// MyBatis의 동적 태그를 활용할 수 있다.
	public String[] getTypeArr() {
		return type == null? new String[] {}: type.split("");
	}
	
}

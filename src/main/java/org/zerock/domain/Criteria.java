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
	
	public Criteria() {
		this(1,10);
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}

package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


  //페이징 처리를 위해서 필요한 파라미터는 1.페이지번호(pageNum), 2.한페이지당 몇개의 데이터(amount)가 필요하다. 

@Getter
@Setter
@ToString
public class Criteria {
		
	
	
	private int pageNum;
	private int amount;
	
	public Criteria() {
		this(1,10);  //기본값을 1페이지, 10개로 지정
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}

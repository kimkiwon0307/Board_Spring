package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data  // Lombok을 이용해서 생성자와 getter/setter, toString()등을 만들기 위해 @Data어노테이션을 사용한다.
public class BoardVO {
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
}

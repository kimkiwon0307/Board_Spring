package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

		public List<BoardVO> getList();
		
		public void insert(BoardVO board);
		
		public void insertSelectKey(BoardVO board);
		
		public BoardVO read(Long bno);
		
		public int delete(Long bno);
		
		public int update(BoardVO board);
		
		public List<BoardVO> getListWithPaging(Criteria cri); // Criteria 를 파라미터로 사용
		
		public int getTotalCount(Criteria cri); // mybatis에서 전체 데이터의 개수 처리
		
		
}

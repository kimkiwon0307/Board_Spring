package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service  //계층 구조상 주로 비즈니스 영역을 담당하는 객체임을 표시하기 위해 사용
@AllArgsConstructor //모든 파라미터를 이용하는 생성자를 만든다
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper; // BoardMapper 객체가 필요하다
	
	@Override
	public void register(BoardVO board) {
		mapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList(); 
	}

}

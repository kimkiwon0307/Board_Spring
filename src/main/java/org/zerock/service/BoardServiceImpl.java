package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {


		mapper.insertSelectKey(board);
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

	// @Override
	// public List<BoardVO> getList() {
	//
	// log.info("getList..........");
	//
	// return mapper.getList();
	// }

	@Override
	public List<BoardVO> getList(Criteria cri) {


		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {

		return mapper.getTotalCount(cri);
	}

}

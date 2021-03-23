package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;

@Service            // 계층 구조상 주로 비즈니스 영역을 담당하는 객체임을 표시하기위해 사용
@AllArgsConstructor // 모든 파라미터를 이용하는 생성자를 만들기 떄문에 사용
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper mapper;
	
	public List<ReplyVO> getReplyList(Long bno) {
		return mapper.getReplyList(bno);
	}

	@Override
	public int saveReply(ReplyVO reply) {
		// TODO Auto-generated method stub
		return mapper.saveReply(reply);
	}

	@Override
	public int updateReply(ReplyVO reply) {
		// TODO Auto-generated method stub
		return mapper.updateReply(reply);
	}

	@Override
	public int deleteReply(Long rno) {
		// TODO Auto-generated method stub
		return mapper.deleteReply(rno);
	}

	
	
}

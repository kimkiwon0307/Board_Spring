package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.ReplyVO;

public interface ReplyMapper {

		public List<ReplyVO> getReplyList(Long bno);
		
		public int saveReply(ReplyVO reply);
		
		public int updateReply(ReplyVO reply);
		
		public int deleteReply(Long rno);
}

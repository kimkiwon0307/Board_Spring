package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyService {

  public List<ReplyVO> getReplyList(Long bno);
  
  public int saveReply(ReplyVO reply);
  
  public int updateReply(ReplyVO reply);
  
  public int deleteReply(Long rno);
}

package com.iu.s3.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.s3.dao.board.QnaDAO;
import com.iu.s3.model.board.QnaVO;
import com.iu.s3.util.Pager;

@Service
public class QnaService {
	
	@Inject
	private QnaDAO qnaDAO;
	
	//list
	public List<QnaVO> qnaList(Pager pager) throws Exception{
		pager.makeRow();
		pager.makePager(qnaDAO.qnaCount(pager));
		
		return qnaDAO.qnaList(pager);
		
	}
	
	//select
	public QnaVO qnaSelect(int num) throws Exception{
		return qnaDAO.qnaSelect(num);
	}
	
	//insert
	public int qnaWrite(QnaVO qnaVO) throws Exception{
		return qnaDAO.qnaWrite(qnaVO);
	}
	
	//reply
	public int qnaReply(QnaVO qnaVO) throws Exception{
		//부모의 정보
		QnaVO parent = qnaDAO.qnaSelect(qnaVO.getNum());
		int result = qnaDAO.qnaReply(parent);
		qnaVO.setRef(parent.getRef());
		qnaVO.setStep(parent.getStep()+1);
		qnaVO.setDepth(parent.getDepth()+1);
		result = qnaDAO.qnaReply(qnaVO);
		return result;
	}
	//reply Update
	public int qnaReplyUpdate(QnaVO qnaVO) throws Exception{
		return qnaDAO.qnaReplyUpdate(qnaVO);
	}
	
	//delete
	public int qnaDelete(int num) throws Exception {
		return qnaDAO.qnaDelete(num);
	}
}

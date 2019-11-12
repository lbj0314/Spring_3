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
		pager.makePager(qnaDAO.qnaCount());
		
		return qnaDAO.qnaList(pager);
		
	}
	
	//insert
	public int qnaInsert(QnaVO qnaVO) throws Exception{
		return qnaDAO.qnaInsert(qnaVO);
	}
}

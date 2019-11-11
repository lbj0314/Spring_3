package com.iu.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s3.TestAbstractCase;
import com.iu.s3.model.board.QnaVO;
import com.iu.s3.util.RowMaker;

public class QnaDAOTest extends TestAbstractCase {
	
	@Inject
	private QnaDAO qnaDAO;
	
	//list
	//@Test
	public void qnaListTest() throws Exception {
		RowMaker rowMaker = new RowMaker();
		List<QnaVO> list = qnaDAO.qnaList(rowMaker);
		assertNotEquals(0, list.size());
	}
	
	//count
	//@Test
	public void qnaCountTest() throws Exception {
		int count = qnaDAO.qnaCount();
		assertEquals(1, count);
	}
	//insert
	//@Test
	public void qnaInsertTest() throws Exception{
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("twice!");
		qnaVO.setWriter("momo");
		qnaVO.setContents("HELLO! WORLD!");
		int result = qnaDAO.qnaInsert(qnaVO);
		
		assertEquals(1, result);
	}
}

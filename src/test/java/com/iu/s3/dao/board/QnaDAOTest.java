package com.iu.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s3.TestAbstractCase;
import com.iu.s3.model.board.QnaVO;
import com.iu.s3.util.Pager;

public class QnaDAOTest extends TestAbstractCase {
	
	@Inject
	private QnaDAO qnaDAO;
	
	//@Test
	public void qnaDAOTest() throws Exception{
		assertNotNull(qnaDAO);
	}
	
	//list
	//@Test
	public void qnaListTest() throws Exception {
		Pager pager = new Pager();
		List<QnaVO> list = qnaDAO.qnaList(pager);
		assertNotEquals(0, list.size());
	}
	
	//count
	//@Test
	public void qnaCountTest(Pager pager) throws Exception {
		int count = qnaDAO.qnaCount(pager);
		assertEquals(1, count);
	}
	//insert
	@Test
	public void qnaInsertTest() throws Exception{
		QnaVO qnaVO = new QnaVO();
		for(int i = 0; i < 100; i++) {
		qnaVO.setTitle("twice!" + i);
		qnaVO.setWriter("momo" + i);
		qnaVO.setContents("HELLO! WORLD!" + i);
		int result = qnaDAO.qnaInsert(qnaVO);
		Thread.sleep(100);
		}
//		assertEquals(100, result);
	}
}

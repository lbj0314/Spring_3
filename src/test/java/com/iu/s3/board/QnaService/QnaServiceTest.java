package com.iu.s3.board.QnaService;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.iu.s3.TestAbstractCase;
import com.iu.s3.model.board.QnaVO;
import com.iu.s3.service.board.QnaService;
import com.iu.s3.util.Pager;

public class QnaServiceTest extends TestAbstractCase {
	
	private QnaService qnaService;
	
	@Test
	public void qnaListTest() throws Exception {
		Pager pager = new Pager();
		pager.makePager(50);
		List<QnaVO> list = qnaService.qnaList(pager);
		//assertNotEquals(0, list.size());
		assertEquals(1, (int)pager.getStartRow());
		assertEquals(10, (int)pager.getLastRow());
		assertEquals(1, (int)pager.getStartNum());
		assertEquals(5, (int)pager.getLastNum());
	}

}

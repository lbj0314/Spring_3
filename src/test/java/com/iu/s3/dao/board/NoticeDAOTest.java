package com.iu.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s3.TestAbstractCase;
import com.iu.s3.model.board.NoticeVO;

public class NoticeDAOTest extends TestAbstractCase{

	@Inject
	private NoticeDAO noticeDAO;
	
	//@Test
	public void checkDAO() throws Exception{
		assertNotNull(noticeDAO);
	}
	
	//@Test
	public void noticeInsertTest() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("twice!");
		noticeVO.setWriter("momo");
		noticeVO.setContents("HELLO! WORLD!");
		int result = noticeDAO.noticeInsert(noticeVO);
		assertEquals(1, result);
	}
	
	//@Test
	public void noticeDeleteTest() throws Exception{

		int result = noticeDAO.noticeDelete(7);
		assertEquals(1, result);
	}
	
	//@Test
	public void noticeSelectTest() throws Exception{
		NoticeVO noticeVO = noticeDAO.noticeSelect(1);
		assertNotNull(noticeVO);
	}
	
	//@Test
	public void noticeListTest() throws Exception {
		List<NoticeVO> list = noticeDAO.noticeList();
		assertNotEquals(0, list.size());
		
	}
	
	@Test
	public void noticeUpdateTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("hello!");
		noticeVO.setContents("hello! World!");
		noticeVO.setNum(14);
		int result = noticeDAO.noticeUpdate(noticeVO);
		assertEquals(1, result);
	}
}

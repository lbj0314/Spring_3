package com.iu.s3.dao.board;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s3.TestAbstractCase;
import com.iu.s3.model.board.NoticeVO;

public class NoticeDAOTest extends TestAbstractCase{

	@Inject
	private NoticeDAO noticeDAO;
	
	@Test
	public void noticeCountTest() throws Exception {
		int count = noticeDAO.noticeCount()	;
		assertEquals(105, count);
	}
	
	//@Test
	public void checkDAO() throws Exception{
		assertNotNull(noticeDAO);
	}
	
	//@Test
	public void noticeInsertTest() throws Exception {
		for(int i = 0; i < 120; i++) {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("twice!"+i);
		noticeVO.setWriter("momo"+i);
		noticeVO.setContents("HELLO! WORLD!"+i);
		int result = noticeDAO.noticeInsert(noticeVO);
		Thread.sleep(100);
		}
		//assertEquals(1, result);
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
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<NoticeVO> list = noticeDAO.noticeList(map);
		assertNotEquals(0, list.size());
		
	}
	
	//@Test
	public void noticeUpdateTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("hello!");
		noticeVO.setContents("hello! World!");
		noticeVO.setNum(14);
		int result = noticeDAO.noticeUpdate(noticeVO);
		assertEquals(1, result);
	}
}

package com.iu.s3.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.s3.dao.board.NoticeDAO;
import com.iu.s3.model.board.NoticeVO;
import com.iu.s3.util.Pager;

@Service
public class NoticeService {

	@Inject
	private NoticeDAO noticeDAO;

	//insert
	public int noticeInsert(NoticeVO noticeVO) throws Exception{
		return noticeDAO.noticeInsert(noticeVO);
	}

	//delete
	public int noticeDelete(int num) throws Exception{
		return noticeDAO.noticeDelete(num);
	}

	//update
	public int noticeUpdate(NoticeVO noticeVO) throws Exception{
		return noticeDAO.noticeUpdate(noticeVO);
	}

	//list
	public List<NoticeVO> noticeList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePager(noticeDAO.noticeCount(pager));
		
		
		return noticeDAO.noticeList(pager);
	}

	//select One
	public NoticeVO noticeSelect(int num) throws Exception{
		return noticeDAO.noticeSelect(num);
	}


}

package com.iu.s3.dao.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.s3.model.board.NoticeVO;

@Repository
public class NoticeDAO {
	
	@Inject
	private SqlSession sqlSession;
	//어느 mapper 쓸건지 결정
	private static final String NAMESPACE = "noticeMapper."; 
	
	//count
	public int noticeCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "noticeCount");
	}
	
	//list
	public List<NoticeVO> noticeList(Map<String, Integer> map) throws Exception {
		return sqlSession.selectList(NAMESPACE + "noticeList", map);

	}
	//selectOne
	public NoticeVO noticeSelect(int num) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		return sqlSession.selectOne(NAMESPACE + "noticeSelect", map);
		 
	}
	//insert
	public int noticeInsert(NoticeVO noticeVO) throws Exception{
						  //namespace		//id
		return sqlSession.insert(NAMESPACE + "noticeInsert", noticeVO);
	}
	//delete
	public int noticeDelete(int num) throws Exception{
		
		return sqlSession.delete(NAMESPACE + "noticeDelete", num);
	}
	//update
	public int noticeUpdate(NoticeVO noticeVO) throws Exception{
		
		return sqlSession.update(NAMESPACE + "noticeUpdate", noticeVO);
	}
}

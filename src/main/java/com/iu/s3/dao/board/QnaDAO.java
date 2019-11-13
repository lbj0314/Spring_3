package com.iu.s3.dao.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.s3.model.board.QnaVO;
import com.iu.s3.util.Pager;

@Repository
public class QnaDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "qnaMapper."; 
	
	//count
	public int qnaCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "qnaCount", pager);
	}
	
	//list
	public List<QnaVO> qnaList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "qnaList", pager);
	}
	
	//select One
	public QnaVO qnaSelect(int num) throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		return sqlSession.selectOne(NAMESPACE + "qnaSelect", map);
	}
	
	//insert
	public int qnaWrite(QnaVO qnaVO) throws Exception{
		return sqlSession.insert(NAMESPACE + "qnaWrite", qnaVO);
	}
	
	//reply
	public int qnaReply(QnaVO qnaVO) throws Exception{
		return sqlSession.insert(NAMESPACE + "qnaReply", qnaVO);
	}

	//reply
	public int qnaReplyUpdate(QnaVO qnaVO) throws Exception {	
		return sqlSession.update(NAMESPACE + "qnaReplyUpdate", qnaVO);
	}
	
	//delete
	public int qnaDelete(int num) throws Exception{
		return sqlSession.delete(NAMESPACE + "qnaDelete", num);
	}
	
}

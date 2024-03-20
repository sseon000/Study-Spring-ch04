package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.*;
import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class BoardCommentDaoImpl implements BoardCommentDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.fastcampus.ch4.dao.BoardMapper.";
	
	@Override
	public int count(Integer bno) throws Exception {
		return session.selectOne(namespace+"count", bno);
	}
	
	@Override
	public int deleteAll(Integer bno) throws Exception {
		return session.delete(namespace+"deleteAll", bno);
	}
	
	@Override
	public int delete(Integer cno, String commenter) throws Exception {
		Map map = new HashMap();
		map.put("cno", cno);
		map.put("commenter", commenter);
		return session.delete(namespace+"delete", map);
	}
	
	@Override
	public int insert(BoardCommentDto dto) throws Exception {
		return session.insert(namespace+"insert", dto);
	}
	
	@Override
	public List<BoardCommentDto> selectAll(Integer bno) throws Exception {
		return session.selectList(namespace+"selectAll", bno);
	}
	
	@Override
	public BoardCommentDto select(Integer cno) throws Exception {
		return session.selectOne(namespace + "select", cno);
	}
	
	@Override
	public int update(BoardCommentDto dto) throws Exception {
		return session.update(namespace+"update", dto);
	}
}

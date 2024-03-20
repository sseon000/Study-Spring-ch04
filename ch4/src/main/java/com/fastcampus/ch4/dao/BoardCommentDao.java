package com.fastcampus.ch4.dao;

import java.util.List;

import com.fastcampus.ch4.domain.BoardCommentDto;

public interface BoardCommentDao {
	int count(Integer bno) throws Exception;
	int deleteAll(Integer bno) throws Exception;
	int delete(Integer cno, String commenter) throws Exception;
	int insert(BoardCommentDto dto) throws Exception;
	List<BoardCommentDto> selectAll(Integer bno) throws Exception;
	BoardCommentDto select(Integer cno) throws Exception;
	int update(BoardCommentDto dto) throws Exception;
}

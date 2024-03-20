package com.fastcampus.ch4.service;

import java.util.List;

import com.fastcampus.ch4.domain.BoardCommentDto;

public interface BoardCommentService {
	int getCount(Integer bno) throws Exception;
	int remove(Integer cno, Integer bno, String commenter) throws Exception;
	int write(BoardCommentDto dto) throws Exception;
	List<BoardCommentDto> getList(Integer bno) throws Exception;
	BoardCommentDto read(Integer cno) throws Exception;
	int modify(BoardCommentDto commentDto) throws Exception;
}

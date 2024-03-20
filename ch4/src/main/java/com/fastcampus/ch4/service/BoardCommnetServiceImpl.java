package com.fastcampus.ch4.service;

import com.fastcampus.ch4.dao.*;
import com.fastcampus.ch4.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
public class BoardCommnetServiceImpl implements BoardCommentService {
	@Autowired
    BoardDao boardDao;
    @Autowired
    BoardCommentDao boardCommentDao;
    
	@Override
	public int getCount(Integer bno) throws Exception {
		return boardCommentDao.count(bno);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int remove(Integer cno, Integer bno, String commenter) throws Exception {
        int rowCnt = boardDao.updateCommentCnt(bno, -1);
        System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
		rowCnt = boardCommentDao.delete(cno, commenter);
		return rowCnt;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int write(BoardCommentDto dto) throws Exception {
		boardDao.updateCommentCnt(dto.getBno(), 1);
		return boardCommentDao.insert(dto);
	}

	@Override
	public List<BoardCommentDto> getList(Integer bno) throws Exception {
		return boardCommentDao.selectAll(bno);
	}

	@Override
	public BoardCommentDto read(Integer cno) throws Exception {
		return boardCommentDao.select(cno);
	}

	@Override
	public int modify(BoardCommentDto commentDto) throws Exception {
		return boardCommentDao.update(commentDto);
	}

}

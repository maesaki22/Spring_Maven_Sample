package com.springtest.study.mboard.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtest.study.mboard.board.dao.IBoardDao;
import com.springtest.study.mboard.board.model.Board;
import com.springtest.study.mboard.board.model.BoardSearch;
import com.springtest.study.mboard.board.service.IBoardService;
import com.springtest.study.mboard.common.search.Pagenation;

@Service
public class BoardServiceImpl implements IBoardService{

	@Autowired
	IBoardDao iBoardDao;
	
	@Override
	public List<Board> selectBoardList(BoardSearch boardSearch) {
		// TODO Auto-generated method stub
		if(boardSearch.getPagenation() == null) {
			boardSearch.setPagenation(new Pagenation());
		}

		int count = iBoardDao.selectBoardListCount(boardSearch);
		boardSearch.getPagenation().setRecordTotalCount(count);
		List<Board> boardList = null;
		// 검색조건에 맞는 수를 찾는다.
		// 검색항목이 0이라면 List객체의 null을 반환한다.
		if (count > 0) {
			boardSearch.getPagenation().processZero();
			boardList = iBoardDao.selectBoardList(boardSearch);
		}
		return boardList;
	}

	
}

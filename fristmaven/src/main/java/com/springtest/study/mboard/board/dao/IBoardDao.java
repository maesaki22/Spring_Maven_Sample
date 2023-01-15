package com.springtest.study.mboard.board.dao;

import java.util.List;

import com.springtest.study.mboard.board.model.Board;
import com.springtest.study.mboard.board.model.BoardSearch;

public interface IBoardDao {
	
	int selectBoardListCount(BoardSearch boardSearch);
	List<Board>  selectBoardList(BoardSearch boardSearch);
}

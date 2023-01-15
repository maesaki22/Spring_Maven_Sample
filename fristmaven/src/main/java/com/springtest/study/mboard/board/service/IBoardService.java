package com.springtest.study.mboard.board.service;

import java.util.List;

import com.springtest.study.mboard.board.model.Board;
import com.springtest.study.mboard.board.model.BoardSearch;

public interface IBoardService { 

	List<Board> selectBoardList(BoardSearch boardSearch);
}

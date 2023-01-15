package com.springtest.study.mboard.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.springtest.study.mboard.board.dao.IBoardDao;
import com.springtest.study.mboard.board.model.Board;
import com.springtest.study.mboard.board.model.BoardSearch;

@Repository("BoardDaoImpl")
public class BoardDaoImpl implements IBoardDao{
	
	// 매번 mapper namespace 를 입력하기에 번거로움이있으니 경로를 미리 지정해둔다.
	protected static final String SQL_FILE_PATH = "com.springtest.study.mboard.board.mapper.mariadb.BoardMapper.";
	
	@Autowired
	@Qualifier("sqlSessionMariaDB")
	private SqlSession sqlSession;
	
	
	@Override
	public int selectBoardListCount(BoardSearch boardSearch) {
		return ((Integer)sqlSession.selectOne(SQL_FILE_PATH+"selectBoardListCount", boardSearch) ).intValue();
	}


	@Override
	public List<Board> selectBoardList(BoardSearch boardSearch) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(SQL_FILE_PATH+"selectBoardList",boardSearch);
	}

}

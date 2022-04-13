package egovframework.example.board.service.impl;

import java.util.List;

import egovframework.example.board.service.BoardVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("boardMapper")
public interface BoardMapper {

	void insertBoard(BoardVO vo) throws Exception;
	
	void updateBoard(BoardVO vo) throws Exception;
	
	void deleteBoard(BoardVO vo) throws Exception;
	
	BoardVO selectBoard(BoardVO vo) throws Exception;
	
	List<?> selectBoardList(BoardVO vo) throws Exception;
	
	int selectBoardListTotal(BoardVO vo) throws Exception;
	
	String selectLoginCheck(BoardVO vo) throws Exception;
}

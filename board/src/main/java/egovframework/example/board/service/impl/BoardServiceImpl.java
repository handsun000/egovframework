package egovframework.example.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.board.service.BoardService;
import egovframework.example.board.service.BoardVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("boardService")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService{

	@Resource(name = "boardMapper")
	public BoardMapper boardMapper;
	
	@Override
	public String insertBoard(BoardVO vo) throws Exception {
		boardMapper.insertBoard(vo);
		return String.valueOf(vo.getIdx());
	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		boardMapper.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) throws Exception {
		boardMapper.deleteBoard(vo);
	}

	@Override
	public BoardVO selectBoard(BoardVO vo) throws Exception {
		return boardMapper.selectBoard(vo);
	}

	@Override
	public List<?> selectBoardList(BoardVO vo) throws Exception {
		return boardMapper.selectBoardList(vo);
	}

	@Override
	public int selectBoardListTotal(BoardVO vo) throws Exception {
		return boardMapper.selectBoardListTotal(vo);
	}

	@Override
	public String selectLoginCheck(BoardVO vo) throws Exception {
		return boardMapper.selectLoginCheck(vo);
	}
	
}

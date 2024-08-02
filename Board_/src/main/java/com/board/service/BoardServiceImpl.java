package com.board.service; //비즈니스 로직을 담당하는 서비스 클래스임을 선

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{ //implements -> boardService 인터페이스를 상속받아 메서드를 구현 
	
	@Autowired
	private BoardMapper boardMapper; //boardMapper -> boardMapper 인터페이스 Bean 주입 
	
	@Override
	public boolean registerBoard(BoardDTO params) { 
		//registerBoard : 게시글을 조회하고, delete_yn의 값을 Y로 변경하여 삭제 처리 / 없는 게시글이거나 delete_yn의 값이 이미 Y인 경우에는 삭제가 실행되지 않음 / 쿼리 실행 결과를 true나 false로 반
		int queryResult = 0;
		
		if(params.getIdx() == null) {
			queryResult = boardMapper.insertBoard(params);
		}else {
			queryResult = boardMapper.updateBoard(params);
		}
		
		return (queryResult == 1) ? true : false;
	}
	
	@Override
	public BoardDTO getBoardDetail(Long idx) { //getBoardList : 삭제되지 않은 전체 게시글을 조회 / 게시글이 1개 이상 존재하면 selectBoardList 메서드 결과값을 반환 
		return boardMapper.selectBoardDetail(idx);
	}
	
	@Override
	public boolean deleteBoard(Long idx) {
		int queryResult = 0;
		
		BoardDTO board = boardMapper.selectBoardDetail(idx);
		
		if (board != null && "N".equals(board.getDeleteYn())) {
			queryResult = boardMapper.deleteBoard(idx);
		}
		
		return (queryResult == 1) ? true : false;
	}
	
	@Override
	public List<BoardDTO> getBoardList(){
		List<BoardDTO> boardList = Collections.emptyList();
		
		int boardTotalCount = boardMapper.selectBoardTotalCount();
		
		if(boardTotalCount > 0) {
			boardList = boardMapper.selectBoardList();
		}
		return boardList;
	}
}

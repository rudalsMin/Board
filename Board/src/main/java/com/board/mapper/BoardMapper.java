package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.BoardDTO;

@Mapper //@Mapper -> 데이터베이스와 통신하기 위한 어노테이션: SQL문을 찾아 실행 
public interface BoardMapper { 
	
	public int insertBoard(BoardDTO params); //insertBoard -> 게시글 생성 
	public BoardDTO selectBoardDetail(Long idx); //selectBoardDetail -> 하나의 게시글 조회 
	public int updateBoard(BoardDTO params); //updateBoard -> 게시글 수정 
	public int deleteBoard(Long idx); //deleteBoard -> 게시글 삭
	public List<BoardDTO> selectBoardList(); //selectBoardList -> 게시글 목록 조회 
	public int selectBoardTotalCount(); //selectBoardTotalCount -> 삭제여부가 'N'으로 지정된 게시글 개수 조회 

}

package com.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootTest
public class MapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testOfInsert() {
		BoardDTO params = new BoardDTO();
		params.setTitle("1번 게시글 제목");
		params.setContent("1번 게시글 내용");
		params.setWriter("테스터");
		
		int result = boardMapper.insertBoard(params);
		System.out.println("결과는 " + result + "입니다.");
	}
	@Test
	public void testOfSelectDetail() {
		BoardDTO board = boardMapper.selectBoardDetail((long)1); 
		//selectBoardDetail: BoardDTO타입 객체 변수 board에 메서드 결과 저장 
		//(long)1: 데이터베이스의 1번 게시글을 조회하기 위한 PK값인 idx 
		try { //Jackson 라이브러리를 통해 JSON 문자열로 변경한 뒤에 콘솔에 출력 
			String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
			System.out.println("====================");
			System.out.println(boardJson);
			System.out.println("====================");
		}catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testOfUpdate() { //BoardDTO 타입 객체 변수 board에 수정한 메서드 결과 저
		BoardDTO params = new BoardDTO();
		params.setTitle("1번 게시글 제목을 수정합니다.");
		params.setContent("1번 게시글 내용을 수정합니다.");
		params.setWriter("홍길동");
		params.setIdx((long)1);
		
		int result = boardMapper.updateBoard(params); 
		if (result == 1) {
			BoardDTO board = boardMapper.selectBoardDetail((long)1);
			try {
				String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
				
				System.out.println("====================");
				System.out.println(boardJson);
				System.out.println("====================");
			}catch (JsonProcessingException e) {
				e.printStackTrace();
				
//result: UPDATE쿼리가 실행된 횟수가 저장
//수정이 완료되면, 수정된 게시글 정보를 JSON 문자열로 출력 
			}
		}
	}
	@Test
	public void testOfDelete() {
		int result = boardMapper.deleteBoard((long)1); //deleteBoard: BoardDTO 타입 객체 변수 board의 파라미터 값인 게시글 번호(idx)를 지정하여 게시글 삭제 처리 
		if (result == 1) {
			BoardDTO board = boardMapper.selectBoardDetail((long)1);
			try {
				String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
				
				System.out.println("====================");
				System.out.println(boardJson);
				System.out.println("====================");
			}catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	@Test
	public void testSelectList() {
		int boardTotalCount = boardMapper.selectBoardTotalCount();
		if (boardTotalCount > 0) {
			List<BoardDTO> boardList = boardMapper.selectBoardList();
			if (CollectionUtils.isEmpty(boardList) == false) {
				for(BoardDTO board : boardList) {
					System.out.println("====================");
					System.out.println(board.getTitle());
					System.out.println(board.getContent());
					System.out.println(board.getWriter());
					System.out.println("====================");
				}
			}
		}
	}

}


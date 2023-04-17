package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.vo.BoardVO;

public class BoardService {

	private BoardDAO boardDao;

	public void BookSearchUI() {
		
	}
	
	public BoardService() {
		boardDao = new BoardDAO();
	}

	public void insertBoard(BoardVO board) {

		boardDao.insertBoard(board);
	}

	public BoardVO selectBoard(String id, String pw) {
		BoardVO board = boardDao.selectBoardById(id, pw);
		return board;
	}

	public void login(String id, String pw) {
		BoardVO board = selectBoard(id, pw);

		if (board != null) {
			// 로그인 성공
			// 다음 페이지로 이동하는 코드 작성
		} else {
			// 로그인 실패
			System.out.println("아이디나 비밀번호가 일치하지 않습니다.");
		}
	}
	public List<BoardVO> searchBook(String keyword) {
	    List<BoardVO> bookList = boardDao.searchBookByKeyword(keyword);
	    return bookList;
	}

	public boolean isRented(String isbn) {
		
		return false;
	}
	
	

}

package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class LogInUI extends BaseUI {

	private BoardService service;

	public LogInUI() {
		service = new BoardService();
	}

	@Override
	public void execute() throws Exception {
		String id = scanStr("아이디 : ");
		String pw = scanStr("패스워드 : ");
		BoardVO board = service.selectBoard(id,pw);
		
		if(board != null) {
			System.out.println("로그인에 성공하였습니다.");
			boolean loggedIn = true;
			while(loggedIn) {
				int type = scanInt("1.도서검색 2.도서대여 3.로그아웃 : ");
				switch(type) {
					case 1:  
						BookSearchUI bookSearchUI = new BookSearchUI();
				    bookSearchUI.execute();
				    break;
						
					case 2:
						RentaBook rentaBook = new RentaBook();
						rentaBook.execute();
						break;
					case 3:
						loggedIn = false;
						System.out.println("로그아웃 되었습니다.");
						break;
					default:
						System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
						break;
				}
			}
		}
		else {
			System.out.println("아이디나 패스워드가 잘못되었습니다.");
		}
	}
}

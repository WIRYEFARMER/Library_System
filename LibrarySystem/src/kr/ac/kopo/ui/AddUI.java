package kr.ac.kopo.ui;

import kr.ac.kopo.BoardServiceFactory;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class AddUI extends BaseUI {
	private BoardService boardService;

	public AddUI() {
		boardService = BoardServiceFactory.getInstance();
	}

	@Override
	public void execute() throws Exception {

		String id = scanStr("생성하실 아이디를 입력하세요 : ");
		String pw = scanStr("사용하실 비밀번호를 입렵하세요 : ");
		String name = scanStr("실명을 입력하세요 : ");
		String birth = scanStr("생년월일을 입력하세요(예시:940628) : ");
		String email = scanStr("이메일을 입력하세요 : ");
		String phone = scanStr("휴대폰 번호를 입력하세요 : ");
		BoardVO board = new BoardVO();
		board.setId(id);
		board.setPw(pw);
		board.setName(name);
		board.setBirth(birth);
		board.setEmail(email);
		board.setPhone(phone);

		boardService.insertBoard(board);

		System.out.println("새 글 등록을 완료하였습니다.");
	}

}
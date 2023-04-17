package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.vo.BoardVO;

public class RentaBook {
	private Scanner sc;
	private BoardDAO dao;

	public RentaBook() {
		sc = new Scanner(System.in);
		dao = new BoardDAO();
	}

	public void execute() throws Exception {
		System.out.println("도서 대여를 진행합니다.");
		System.out.print("대여할 도서의 ISBN을 입력하세요: ");
		String isbn = sc.next();

		BoardVO book = dao.getBook(isbn);
		if (book == null) {
			System.out.println("존재하지 않는 책입니다.");
			return;
		}

		int qty = book.getQty();
		if (qty == 0) {
			System.out.println("현재 대여 가능한 도서가 없거나 이미 대여중입니다.");
			return;
		}

		System.out.println("도서명: " + book.getTitle());
		System.out.println("작가명: " + book.getAuthor());
		System.out.println("출판사: " + book.getPublisher());
		System.out.println("대여 가능 수량: " + qty);

		System.out.print("대여하시겠습니까? (Y/N) ");
		String answer = sc.next();
		if (answer.equalsIgnoreCase("Y")) {
			dao.updateQty(isbn);
			System.out.println("도서 대여가 완료되었습니다.");
		} else {
			System.out.println("도서 대여가 취소되었습니다.");
		}
	}
}

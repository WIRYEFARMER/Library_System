package kr.ac.kopo;

import java.util.Scanner;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.ui.ExitUI;
import kr.ac.kopo.ui.IBoardUI;
import kr.ac.kopo.ui.LogInUI;
import kr.ac.kopo.ui.SignInUI;

public class BoardUI extends BaseUI implements IBoardUI {

	private int menu() {
		System.out.println("***도서관 시스템***");
		System.out.println("1.회원가입");
		System.out.println("2.로그인");
		System.out.println("0.종료");
		System.out.print("원하는 항목을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();

		sc.nextLine(); // 버퍼지우기

		return type;
	}

	@Override
	public void execute() throws Exception {

		while (true) {
			int type = menu();
			IBoardUI ui = null;
			switch (type) {
			case 1:
				ui = new SignInUI();
				System.out.println("회원가입");
				break;
			case 2:
				ui = new LogInUI();
				System.out.println("로그인");
				break;
			case 0:
				ui = new ExitUI();
				break;
			}
			if (ui !=null) {
				ui.execute();
				}else {
					System.out.println("잘 못 입 력 하 셨 습 니 다");
				}
		}
	}
}

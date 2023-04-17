package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.dao.BoardDAO;

public abstract class BaseUI implements IBoardUI {
	
	private Scanner sc;
	
	
	public BaseUI() {
		sc = new Scanner(System.in);
		
		
	}
	protected int scanInt(String msg) {
		System.out.println(msg);
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	protected String scanStr(String msg) {
		System.out.println(msg);
		
		return sc.nextLine();

	}
	
	

}

package kr.ac.kopo.ui;

public class ExitUI extends BaseUI {
	
	@Override
	public void execute() throws Exception{
		System.out.println("----------------------------------");
		System.out.println("\t게시판을 종료합니다잉");
		System.out.println("----------------------------------");
		System.exit(0);
		
	}

}

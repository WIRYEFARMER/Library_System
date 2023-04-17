package kr.ac.kopo;


public class BoardMain {

	public static void main(String[] args) {
		try {
			new BoardUI().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

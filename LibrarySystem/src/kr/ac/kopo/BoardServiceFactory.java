package kr.ac.kopo;

import kr.ac.kopo.service.BoardService;

public class BoardServiceFactory {

	private static BoardService service = null;

	public static BoardService getInstance() {
		if (service == null) {
			service = new BoardService();
		}
		return service;
	}

}

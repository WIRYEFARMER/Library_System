package kr.ac.kopo.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BoardVO;

public class BookSearchUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM book_info WHERE isbn LIKE ? OR title LIKE ? OR author LIKE ? OR publisher LIKE ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

			String keyword = scanStr("검색어 : ");

			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + keyword + "%");
			rs = pstmt.executeQuery();

			List<BoardVO> bookList = new ArrayList<>();

			while (rs.next()) {
				String isbn = rs.getString("isbn");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");

				BoardVO book = new BoardVO();
				book.setIsbn(isbn);
				book.setTitle(title);
				book.setAuthor(author);
				book.setPublisher(publisher);

				bookList.add(book);
			}

			System.out.printf("총 %d권의 도서가 검색되었습니다.%n", bookList.size());
			for (BoardVO book : bookList) {
				System.out.printf("%s\t%s\t%s\t%s%n", book.getIsbn(), book.getTitle(), book.getAuthor(),
						book.getPublisher());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

		
	}
}

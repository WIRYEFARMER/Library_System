package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BoardVO;

//오라클 DB t_board에 게시글 CRUD하는 DAO클래스

public class BoardDAO {
	private List<BoardVO> boardList;

	public void insertBoard(BoardVO board) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into lib_sys(id, pw, name, birth, email, phone ) ");
		sql.append("values( ? , ? , ? , ? , ? , ? ) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, board.getId());
			pstmt.setString(2, board.getPw());
			pstmt.setString(3, board.getName());
			pstmt.setString(4, board.getBirth());
			pstmt.setString(5, board.getEmail());
			pstmt.setString(6, board.getPhone());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public BoardVO selectBoardById(String id, String pw) {
		BoardVO board = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select id, pw ");
		sql.append("from lib_sys ");
		sql.append("where id = ? and pw = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String id1 = rs.getString("id");
				String pw1 = rs.getString("pw");
				board = new BoardVO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return board;
	}

	public List<BoardVO> searchBookByKeyword(String keyword) {
		List<BoardVO> bookList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			String sql = "SELECT * FROM lib_sys WHERE isbn LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO book = new BoardVO();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bookList;
	}

	public List<BoardVO> searchBook(String keyword) {
		List<BoardVO> bookList = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM book_info WHERE isbn ?");
		ResultSet rs = null;

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

			pstmt.setString(1, "%" + keyword + "%");
			pstmt.executeQuery();

			bookList = new ArrayList<>();
			while (rs.next()) {
				BoardVO book = new BoardVO();
				book.setIsbn(rs.getString("isbn"));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return bookList;
	}

	public void updateQty(String isbn) {
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement("UPDATE book_info SET qty = qty - 1 WHERE isbn = ?")) {
			pstmt.setString(1, isbn);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public BoardVO getBook(String isbn) {
		BoardVO book = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM book_info WHERE isbn = ?");
		ResultSet rs = null;

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				book = new BoardVO();
				book.setIsbn(rs.getString("isbn"));
				book.setQty(rs.getInt("qty"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return book;
	}

}

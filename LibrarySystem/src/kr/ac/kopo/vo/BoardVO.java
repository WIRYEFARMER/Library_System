package kr.ac.kopo.vo;

public class BoardVO  {
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String email;
	private String phone;
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String book;
	private int qty;

	public String getBook() {
		return book;
	}


	public void setBook(String book) {
		this.book = book;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
	public boolean isRented(String isbn) {
		// TODO Auto-generated method stub
		return false;
	}

	public BoardVO getBook(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}
	public void rentBook(String isbn) {
		// TODO Auto-generated method stub
		
	}



}

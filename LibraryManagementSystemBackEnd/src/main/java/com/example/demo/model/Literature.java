package com.example.demo.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table( name = "literature" )
public class Literature {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "author")
	private String  author;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "issued_date")
	private String issuedDate;
	
	@Column(name = "total_books")
	private int totalBooks ;
	
	@Column(name = "lended_books")
	private int lendedBooks ;
	
	
	
	
	public Literature() {
		// TODO Auto-generated constructor stub
	}

	


	
	public Literature(String isbn, String author, String title, String category, String issuedDate, int totalBooks,
			int lendedBooks) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.category = category;
		this.issuedDate = issuedDate;
		this.totalBooks = totalBooks;
		this.lendedBooks = lendedBooks;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}



	public int getTotalBooks() {
		return totalBooks;
	}



	public void setTotalBooks(int totalBooks) {
		this.totalBooks = totalBooks;
	}



	public int getLendedBooks() {
		return lendedBooks;
	}



	public void setLendedBooks(int lendedBooks) {
		this.lendedBooks = lendedBooks;
	}
	
	
	
}

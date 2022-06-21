package com.demo.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "bookcode")
	private String bookCode;
	private String title;
	private String author;
	private String category;
	private Integer booked;
	
	public Book () {
		
	}

	public Book(String bookCode, String title, String author, String category, Integer booked) {
		super();
		this.bookCode = bookCode;
		this.title = title;
		this.author = author;
		this.category = category;
		this.booked = booked;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getBooked() {
		return booked;
	}

	public void setBooked(Integer booked) {
		this.booked = booked;
	}
	
	
	
}

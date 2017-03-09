package com.team3.LMS.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the publisher_details database table.
 * 
 */
@Entity
@Table(name="publisher_details")
public class PublisherDetail {

	@Id
	@Column(name="publisher_id")
	private int publisherId;

	@Column(name="publisher_name")
	private String publisherName;

	//bi-directional many-to-one association to Book
	@OneToMany(mappedBy="publisherDetail")
	private List<Book> books;

	public PublisherDetail() {
	}

	public int getPublisherId() {
		return this.publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return this.publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setPublisherDetail(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setPublisherDetail(null);

		return book;
	}

}
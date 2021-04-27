package com.example.demo.entity;

import java.sql.Date;

public class Book_t {

	private Integer book_id;
	private String title;
	private String author;
	private Integer category_id;
	private Integer max_num;
	private Date entry_day;
	private Date updatetime;
	private Integer isdeleted;
	private Integer page;


	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
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
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getMax_num() {
		return max_num;
	}
	public void setMax_num(Integer max_num) {
		this.max_num = max_num;
	}
	public Date getEntry_day() {
		return entry_day;
	}
	public void setEntry_day(Date entry_day) {
		this.entry_day = entry_day;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(Integer isdeleted) {
		this.isdeleted = isdeleted;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}

}

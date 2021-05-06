package com.example.demo.mapper.book_a;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.common.Book;
import com.example.demo.entity.common.History;
import com.example.demo.entity.display.lendingbook.LendingBook;

@Mapper
public interface BookMapper_a {

	// 書籍表示
	List<Book> select();

	// 借りている書籍一覧
	List<LendingBook> returnSelect();

	// 貸出 t_loanに書籍を登録
	public void insert(LendingBook lendingBook);

	public void update(List<Book> book);

	List<Book> bookSelect(int book_id);

	// 返却 t_Historyにt_loanの書籍を登録
	public void returnInsert(History history);

	public void returnDelete();

}

package com.example.demo.Mapper;

//import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.repository.Book;
import com.example.demo.repository.LendingBook;

@Mapper
public interface BookMapper {

	// 書籍表示
	List<Book> select();

	// 借りている書籍一覧
	List<LendingBook> returnSelect();

	// 貸出 t_loanに書籍を登録
	public void insert(LendingBook lendingBook);

	public void update(Book book);

	List<Book> bookSelect(int book_id);

	// 返却 t_Historyにt_loanの書籍を登録
	public void returnInsert(int id);

	public void returnDelete(int book_id);

	Optional<Book> maxnumSelect(int book_id);
}

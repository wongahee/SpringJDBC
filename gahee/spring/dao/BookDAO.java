package gahee.spring.dao;

import java.util.List;

import gahee.spring.vo.Book;

public interface BookDAO {
	int insertBook(Book b);
	List<Book> selectAllBook();
	Book selectOneBook(String bookid);
	int updateBook(Book b);
	int deleteBook(String bookid);
	
}
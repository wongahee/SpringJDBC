package gahee.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gahee.spring.dao.BookDAO;
import gahee.spring.vo.Book;

@Service("bsrv02")
public class BookService02Impl implements BookService {
	
	@Autowired
	private BookDAO bdao02;

	@Override
	public void newBook() {
		Book b = new Book("3","스프링5기초","더조은","25000");
		
		int cnt = bdao02.insertBook(b);
		if(cnt > 0) System.out.println("책데이터 입력 완료!!");
	}

	@Override
	public List<Book> readBook() {
		StringBuffer sb = new StringBuffer();
		List<Book> bs = bdao02.selectAllBook();
		
		for(Book b:bs)sb.append(b);
		System.out.println(sb.toString());
		
		return null;
	}

	@Override
	public Book readOneBook() {
		Book b = bdao02.selectOneBook("3");
		System.out.println(b);
		
		return null;
	}

	@Override
	public void modifyBook(Book b) {
		int cnt = bdao02.updateBook(b);
		if(cnt > 0) System.out.println("책데이터 수정 완료!!");
	}

	@Override
	public void removeBook(String bookid) {
		int cnt = bdao02.deleteBook(bookid);
		if(cnt > 0) System.out.println("책데이터 삭제 완료!!");
	}

}
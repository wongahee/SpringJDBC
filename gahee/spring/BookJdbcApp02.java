package gahee.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gahee.spring.service.BookService;
import gahee.spring.vo.Book;

public class BookJdbcApp02 {
	public static void main(String[] args) {
		
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("springjdbc02.xml");
		
		BookService bsrv = (BookService)ctx.getBean("bsrv02");
		
		// Books 데이터 입력
		//bsrv.newBook();
		
		// Books 데이터 조회
		//bsrv.readBook();
		
		// Books 데이터 상세조회
		//bsrv.readOneBook();
		
		// Books 데이터 수정
		//Book b = new Book("3","Spring기초","더나은","35000");
		//bsrv.modifyBook(b);
		
		// Books 데이터 삭제
		bsrv.removeBook("11");
		
	}
}
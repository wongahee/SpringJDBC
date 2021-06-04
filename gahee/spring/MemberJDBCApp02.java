package gahee.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gahee.spring.service.MemberService;

public class MemberJDBCApp02 {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("springjdbc02.xml");
		
		MemberService mbsrv = (MemberService) ctx.getBean("mbsrv02");
		
		// 회원 등록 후 db에 저장
		//mbsrv.newMember();
		
		// 회원 데이터 전체조회
		//mbsrv.readAllMember(); 
		
		// 회원 데이터 상세조회
		//mbsrv.readOneMember(7);
		
		// 회원 데이터 수정
		//mbsrv.modifyMember();
		
		// 회원 데이터 삭제
		mbsrv.removeMember();
	}

}

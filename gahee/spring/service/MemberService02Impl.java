package gahee.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gahee.spring.dao.MemberDAO;
import gahee.spring.vo.Member;

@Service("mbsrv02")
public class MemberService02Impl implements MemberService {

	@Autowired 
	private MemberDAO mbdao02; // DAO 불러오기

	@Override
	public void newMember() {
		Member mb = new Member("xyz987","123abc","지현","지현@naver.com");
		
		mbdao02.insertMember(mb);
		System.out.println("회원가입완료!!");
	}

	@Override
	public void readAllMember() {
		StringBuffer sb = new StringBuffer();
		List<Member> mbs = mbdao02.selectAllMember();
		
		for(Member mb : mbs) sb.append(mb); 
		// member클래스에 toString부분이 출력됨
		
		System.out.println(sb);
	}

	@Override
	public void readOneMember(int mno) {
		Member mb = mbdao02.selectOneMember(mno);
		System.out.println(mb);
	}

	@Override
	public void modifyMember() {
		Member mb = new Member("2","","333","선바","sunba@naver","");
		
		mbdao02.updateMember(mb);
	}

	@Override
	public void removeMember() {
		mbdao02.deleteMember(10);
	}
}
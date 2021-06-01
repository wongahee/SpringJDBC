package gahee.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gahee.spring.dao.MemberDAO;
import gahee.spring.vo.Member;

@Service("mbsrv")
public class MemberServiceImpl implements MemberService {

	@Autowired 
	private MemberDAO mbdao; // DAO 불러오기

	@Override
	public void newMember() {
		Member mb = new Member("xyz987","123abc","지현","지현@naver.com");
		
		mbdao.insertMember(mb);
		System.out.println("회원가입완료!!");
	}

	@Override
	public void readAllMember() {
		StringBuffer sb = new StringBuffer();
		List<Member> mbs = mbdao.selectAllMember();
		
		for(Member mb : mbs) sb.append(mb); 
		// member클래스에 toString부분이 출력됨
		
		System.out.println(sb);
	}

	@Override
	public void readOneMember(int mno) {
		Member mb = mbdao.selectOneMember(mno);
		System.out.println(mb);
	}

	@Override
	public void modifyMember() {
		Member mb = new Member("2","","123456","수지","abc123@naver","");
		
		mbdao.updateMember(mb);
	}

	@Override
	public void removeMember() {
		mbdao.deleteMember(8);
	}
}
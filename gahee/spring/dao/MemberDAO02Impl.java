package gahee.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gahee.spring.vo.Member;

@Repository("mbdao02")
public class MemberDAO02Impl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertMember(Member mb) {
		int cnt = sqlSession.insert("member.insertMember", mb);
		if(cnt > 0) System.out.println("회원 추가 완료!");
	}

	@Override
	public List<Member> selectAllMember() {
		return sqlSession.selectList("member.selectMember");
	}

	@Override
	public Member selectOneMember(int mno) {
		return sqlSession.selectOne("member.selectOneMember", mno) ;
	}

	@Override
	public void updateMember(Member mb) {
		int cnt = sqlSession.update("member.updateMember", mb);
		if(cnt > 0) System.out.println("회원정보 수정완료!!");
	}

	@Override
	public void deleteMember(int mno) {
		int cnt = sqlSession.delete("member.deleteMember", mno);
		if(cnt > 0) System.out.println("회원정보 삭제완료!!");
	}

}
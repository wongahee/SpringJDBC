package gahee.spring.dao;

import java.util.List;

import gahee.spring.vo.Member;

public interface MemberDAO {
	void insertMember(Member mb);
	List<Member> selectAllMember();
	Member selectOneMember(int mno);
	void updateMember(Member mb);
	void deleteMember(int mno);
	
}
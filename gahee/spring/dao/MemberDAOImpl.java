package gahee.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gahee.spring.vo.Member;

@Repository("mbdao")
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertMember(Member mb) {
		String sql = " insert into member (userid,passwd,name,email) "
					+ " values (?,?,?,?) ";
		
		Object[] params = new Object[] {
			mb.getUserid(), mb.getPasswd(), mb.getName(), mb.getEmail()	
		};
		
		int cnt = jdbcTemplate.update(sql, params);
		if(cnt > 0) System.out.println("회원 추가됨!");
	}

	@Override
	public List<Member> selectAllMember() {
		String sql = " select mno,userid,name,joindate from member "
					+ " order by mno desc ";
		
		RowMapper<Member> mapper = new MemberMapper();
		
		return jdbcTemplate.query(sql, mapper);
	}
	protected class MemberMapper implements RowMapper<Member> {

		@Override
		public Member mapRow(ResultSet rs, int num) throws SQLException {
			String mno = rs.getString("mno");
			String userid = rs.getString("userid");
			String name = rs.getString("name");
			String joindate = rs.getString("joindate").substring(0,10);
					// 날짜부분 10자리까지만 출력
			
			Member mb = new Member(mno,userid,"",name,"",joindate);
			return mb;
		}
	}

	@Override
	public Member selectOneMember(int mno) {
		String sql = " select mno,userid,name,email,joindate "
					+ " from member where mno = ? ";
		
		Object [] params = new Object[] { mno };
		
		RowMapper<Member> mapper = new MemberOneMapper();

		return jdbcTemplate.queryForObject(sql, params, mapper);
	}
	protected class MemberOneMapper implements RowMapper<Member> {

		@Override
		public Member mapRow(ResultSet rs, int num) throws SQLException {
			String mno = rs.getString("mno");
			String userid = rs.getString("userid");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String joindate = rs.getString("joindate").substring(0,10);
			
			Member mb = new Member(mno,userid,"",name,email,joindate);
			return mb;
		}
	}

	@Override
	public void updateMember(Member mb) {
		String sql = " update member set passwd = ?, name = ?, email = ? "
				   + " where mno = ? ";
		
		Object[] params = new Object[] {
								mb.getPasswd(), mb.getName(), mb.getEmail(), 
								mb.getMno() };
		
		int cnt = jdbcTemplate.update(sql, params);
		if(cnt > 0) System.out.println("회원정보 수정완료!!");
	}

	@Override
	public void deleteMember(int mno) {
		String sql = " delete from member where mno = ? ";
		Object [] params = new Object[] { mno };

		int cnt = jdbcTemplate.update(sql, params);
		if(cnt > 0) System.out.println("회원정보 삭제완료!!");
	}

}
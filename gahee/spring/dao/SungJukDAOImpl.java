package gahee.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gahee.spring.vo.SungJuk;

@Repository("sjdao")
public class SungJukDAOImpl implements SungJukDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertSungJuk(SungJuk sj) {
		String sql =" insert into sungjuk (name,kor,eng,mat,tot,mean,grd) "
					+ " values (?,?,?,?,?,?,?) ";
		
		Object[] params = new Object[] {
						sj.getName(), sj.getKor(), sj.getEng(), sj.getMat(),
						sj.getTot(), sj.getAvg(), sj.getGrd()+"" };
		
		int cnt = jdbcTemplate.update(sql, params);
		
		if(cnt > 0) System.out.println("성적 추가됨!");
	}

	@Override
	public List<SungJuk> selectAllSungJuk() {
		String sql = " select name, kor, eng, mat from sungjuk "
					+ " order by sjno desc ";
		
		RowMapper<SungJuk> mapper = new SungJukMapper();
		// 콜백클래스만 등록하고 호출/실행은 따로하지않음
		// 단, query 메서드가 실행하는 도중에
		// rs.next가 참인 경우 (=결과집합이 존재하면)
		// IoC 컨테이너가 mapper객체의 mapRow를 호출함
		
		return jdbcTemplate.query(sql, mapper);
	}

	// 성적 데이터를 출력하기 위한 RowMapper 클래스
	protected class SungJukMapper implements RowMapper<SungJuk>{

		@Override
		public SungJuk mapRow(ResultSet rs, int num) throws SQLException {
			//System.out.println(num);
			String name = rs.getString("name");
			int kor = rs.getInt("kor");
			int eng = rs.getInt("eng");
			int mat = rs.getInt("mat");
			
			SungJuk sj = new SungJuk(name,kor,eng,mat);
					
			return sj;
		}
	}

	@Override
	public SungJuk selectOneSungJuk(int sjno) {
		String sql = " select * from sungjuk where sjno = ? ";
		
		Object[] params = new Object[] { sjno };
		
		RowMapper<SungJuk> mapper = new SungJukOneMapper();
		// 콜백클래스만 등록하고 호출/실행은 따로하지않음
		// 단, query 메서드가 실행하는 도중에
		// rs.next가 참인 경우 (=결과집합이 존재하면)
		// IoC 컨테이너가 mapper객체의 mapRow를 호출함
		
		return jdbcTemplate.queryForObject(sql, params, mapper);
	}
	
	protected class SungJukOneMapper implements RowMapper<SungJuk> {

		@Override
		public SungJuk mapRow(ResultSet rs, int num) throws SQLException {
			
			String name = rs.getString("name");
			int kor = rs.getInt("kor");
			int eng = rs.getInt("eng");
			int mat = rs.getInt("mat");
			
			SungJuk sj = new SungJuk(name,kor,eng,mat);
			sj.setTot(rs.getInt("tot"));
			sj.setAvg(rs.getInt("mean"));
			sj.setGrd(rs.getString("grd").charAt(0));
			
			return sj;
		}
	}

	@Override
	public void updateSungJuk(SungJuk sj) {
		String sql = " update sungjuk set kor = ?, eng = ?, mat = ?, "
				   + " tot = ?, mean = ?, grd = ? where sjno = ? ";
		Object[] params = new Object[] {
									sj.getKor(), sj.getEng(), sj.getMat(), 
									sj.getTot(), sj.getAvg(), sj.getGrd()+"", 
									sj.getSjno() };
		
		int cnt = jdbcTemplate.update(sql, params);
		if(cnt > 0) System.out.println("수정완료!!");
	}

	@Override
	public void deleteSungJuk(int sjno) {
		String sql = " delete from sungjuk where sjno = ? ";
		Object[] params = new Object[] { sjno };
		
		int cnt = jdbcTemplate.update(sql, params);
		if(cnt > 0) System.out.println("데이터 삭제 완료!!");
	}
	
	
}
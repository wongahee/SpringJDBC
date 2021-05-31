package gahee.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import gahee.spring.vo.SungJuk;

@Repository("sjdao")
public class SungJukDAOImpl implements SungJukDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertSungJuk(SungJuk sj) {
		String sql =" insert into sungjuk (name,kor,eng,mat,tot,mean,grd) "
					+ " values (?,?,?,?,?,?,?)";
		
		Object[] params = new Object[] {
						sj.getName(), sj.getKor(), sj.getEng(), sj.getMat(),
						sj.getTot(), sj.getAvg(), sj.getGrd()+"" };
		
		int cnt = jdbcTemplate.update(sql, params);
		
		if(cnt > 0) System.out.println("성적 추가됨!");
	}

}
package gahee.spring.dao;

import java.util.List;

import gahee.spring.vo.SungJuk;

public interface SungJukDAO {
	void insertSungJuk(SungJuk sj);
	List<SungJuk> selectAllSungJuk();
	SungJuk selectOneSungJuk(int sjno);
	void updateSungJuk(SungJuk sj);
	void deleteSungJuk(int i);
	
}
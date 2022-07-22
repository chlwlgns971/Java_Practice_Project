package BankManage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Util.SqlMapClientFactory;

public class BankInfoDaoImpl implements BankInfoDao {
	SqlMapClientFactory scf;
	
	//singleton 1번
	private static BankInfoDaoImpl dao;
	
	// 생성자 and Singleton 2번  
	private BankInfoDaoImpl() {
		scf=new SqlMapClientFactory();
	}
	//3번
	public static BankInfoDaoImpl getInstance() {
		if(dao==null) dao=new BankInfoDaoImpl();
		return dao;
	}

	@Override
	public int insert(BankVO bankVo) {
		int cnt=0;
		try {
			Object obj=scf.getSmc().insert("Bank.insertBank",bankVo);
			if(obj==null) cnt=1;
			
		} catch(SQLException e) {
			cnt=0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int delete(String bank_no) {
		int cnt=0;
		try {
			cnt=scf.getSmc().delete("Bank.deleteBank",bank_no);
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int update(BankVO bankVo) {
		int cnt=0;
		try {
			cnt=scf.getSmc().update("Bank.updateBank",bankVo);
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BankVO> getAll() {
		List<BankVO> list=new ArrayList<BankVO>();
		try {
			list=scf.getSmc().queryForList("Bank.getAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int checkNo(String bank_no) {
		int count=0;
		try {
			count=(Integer)scf.getSmc().queryForObject("Bank.checkNo", bank_no);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}

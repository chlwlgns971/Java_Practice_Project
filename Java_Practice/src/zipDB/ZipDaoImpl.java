package zipDB;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import Util.SqlMapClientFactory;

public class ZipDaoImpl implements ZipDao {
	private static ZipDao dao;
	private SqlMapClient smc;
	
	public ZipDaoImpl() {
		smc=SqlMapClientFactory.getSmc();
	}
	public static ZipDao getInstance() {
		if(dao==null) dao=new ZipDaoImpl();
		return dao;
	}
	@Override
	public List<ZipVO> selectByDong(String dong) {
		List<ZipVO> list=null;
		try {
			list=smc.queryForList("zip.selectByDong", dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}

package prodTest;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import Util.ProdSqlMapClientFactory;

public class IProdDaoImpl implements IProdDao {
	
	//sqlMapClient 객체가 필요.
	private SqlMapClient smc;
	private static IProdDao dao;
	
	//생성자 - 변수 초기화
	private IProdDaoImpl() {
		smc=ProdSqlMapClientFactory.getSmc();
	}
	public static IProdDao getInstance() {
		if(dao==null) dao=new IProdDaoImpl();
		return dao;
	}

	@Override
	public List<ProdVO> selectAll() {
		List<ProdVO> list=null;
		try {
			list=smc.queryForList("Prod.selectAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

}

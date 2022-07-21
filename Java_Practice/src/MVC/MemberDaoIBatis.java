package MVC;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import IBatis.LprodVO;
import IBatis.SqlMapClientFactory;
import Util.DBUtil3;

public class MemberDaoIBatis implements IMemberDao {
	SqlMapClientFactory scf;
	//1번
	private static MemberDaoIBatis dao;
	//2번
	private MemberDaoIBatis() {
		scf=new SqlMapClientFactory(); 
	}
	//3번
	public static MemberDaoIBatis getInstance() {
		if(dao==null) dao=new MemberDaoIBatis();
		return dao;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		int cnt=0; //반환값이 저장될 변수
		try {
			Object obj=scf.getSmc2().insert("Mymember.insertMymember",memVo);
			if(obj==null) cnt=1;
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int deleteMember(String id) {
		int cnt=0; //반환값이 저장될 변수
		try {
			cnt=scf.getSmc2().delete("Mymember.deleteMymember",id);
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int cnt=0; //반환값이 저장될 변수
		try {
			cnt=scf.getSmc2().update("Mymember.updateMymember",memVo);
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public int updateMember2(Map<String, String> paramMap) {
		int cnt=0;
		try {
			cnt=scf.getSmc2().update("Mymember.updateMymember2",paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> list=new ArrayList<MemberVO>();
		try {
			list=scf.getSmc2().queryForList("Mymember.getAllMymember");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}

	@Override
	public int getMemberIdCount(String id) {
		int count=0;
		try {
			count=(Integer)scf.getSmc2().queryForObject("Mymember.getMemberIdCount", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}

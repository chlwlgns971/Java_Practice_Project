package MVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Util.DBUtil3;

public class MemberDaoImpl implements IMemberDao {
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	//1번
	private static MemberDaoImpl dao;
	//2번
	private MemberDaoImpl() {}
	//3번
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao=new MemberDaoImpl();
		return dao;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		int cnt=0; //반환값이 저장될 변수
		try {
			conn=DBUtil3.getConnection2();
			String sql = "insert into mymember (mem_id, mem_pass, mem_name, mem_tel, mem_addr) "
	                  +"values(?, ?, ?, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,memVo.getMem_id());
			pstmt.setString(2,memVo.getMem_pass());
			pstmt.setString(3,memVo.getMem_name());
			pstmt.setString(4,memVo.getMem_tel());
			pstmt.setString(5,memVo.getMem_addr());
			
			cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {};
			if(conn!=null) try {conn.close();} catch(SQLException e) {};
		}
		return cnt;
	}

	@Override
	public int deleteMember(String id) {
		int cnt=0; //반환값이 저장될 변수
		try {
			conn=DBUtil3.getConnection2();
			String sql="delete from mymember where mem_id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {};
			if(conn!=null) try {conn.close();} catch(SQLException e) {};
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int cnt=0; //반환값이 저장될 변수
		try {
			conn = DBUtil3.getConnection2();
		     
			String sql = " update mymember set "
					+" mem_pass =?, mem_name = ?, mem_tel =?, mem_addr =? "
					+" where mem_id =? ";
		         
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_pass());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			pstmt.setString(5, memVo.getMem_id());  
			cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {};
			if(conn!=null) try {conn.close();} catch(SQLException e) {};
		}
		return cnt;
	}
	
	@Override
	public int updateMember2(Map<String, String> paramMap) {
		conn=null;
		pstmt=null;
		int cnt=0;
		try {
			conn=DBUtil3.getConnection2();
			
			//paramMap에 저장된 key값을 이용하여 쿼리문을 작성하고, 쿼리문에 들어갈 데이터를 셋팅하는 작업을 진행한다.
			String sql = "update mymember set "+paramMap.get("field")+" = ? where mem_id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,paramMap.get("data"));
			pstmt.setString(2,paramMap.get("memid"));
			
			cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> list=new ArrayList<MemberVO>();
		try {
			conn=DBUtil3.getConnection2();
			String sql="select* from mymember";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString("mem_id");
				String pass=rs.getString("mem_pass");
				String name=rs.getString("mem_name"); 
				String tel=rs.getString("mem_tel");
				String addr=rs.getString("mem_addr");
				list.add(new MemberVO(id, pass, name, tel, addr));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {conn.close();} catch(SQLException e) {};
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {};
			if(conn!=null) try {conn.close();} catch(SQLException e) {};
		}
		return list;
	}

	@Override
	public int getMemberIdCount(String id) {
		int count=0;
		try {
			conn=DBUtil3.getConnection2();
			String sql="select count(*) cnt from mymember where mem_id = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {};
			if(conn!=null) try {conn.close();} catch(SQLException e) {};
		}
		return count;
	}
}

package MVCBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MVC.MemberVO;
import Util.DBUtil;
import Util.DBUtil3;

public class BoardDaoImpl implements BoardDao {
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	//Singleton
	private static BoardDaoImpl dao;
	private BoardDaoImpl() {}
	public static BoardDaoImpl getInstance() {
		if(dao==null) dao=new BoardDaoImpl();
		return dao;
	}

	@Override
	public int insert(BoardVO boardVo) {
		int cnt=0;
		try {
			conn=DBUtil3.getConnection2();
			String sql="insert into jdbc_board (board_no, board_title, board_writer, board_date, board_cnt, board_content) "
					+ "values(board_seq.nextVal, ?, ?, sysdate, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_writer());
			pstmt.setInt(3, 0);
			pstmt.setString(4, boardVo.getBoard_content());
			
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
	public int delete(int board_no) {
		int cnt=0;
		try {
			conn=DBUtil3.getConnection2();
			String sql="delete from jdbc_board where board_no = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			
			cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> showPost(int board_no) { 
		List<BoardVO> list=new ArrayList<BoardVO>();
		try {
			conn=DBUtil.getConnection2();
			String sql="select* from jdbc_board where board_no = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int no=rs.getInt("board_no");
				String title=rs.getString("board_title");
				String writer=rs.getString("board_writer");
				String cnt=rs.getString("board_cnt");
				String date=rs.getString("board_date");
				String content=rs.getString("board_content");
				list.add(new BoardVO(title, writer, cnt, content, date, no));
			}
			updateCnt(board_no);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {conn.close();} catch(SQLException e) {};
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {};
			if(conn!=null) try {conn.close();} catch(SQLException e) {};
		}
		return list;
	}

	@Override
	public List<BoardVO> searchPost(String keyWord) {
		List<BoardVO> list=new ArrayList<BoardVO>();
		try {
			conn=DBUtil.getConnection2();
			String sql="select board_no, board_title, board_writer, board_cnt from jdbc_board where board_title like '%'||?||'%'";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, keyWord);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int no=rs.getInt("board_no");
				String title=rs.getString("board_title");
				String writer=rs.getString("board_writer");
				String cnt=rs.getString("board_cnt");
				list.add(new BoardVO(title, writer, cnt, no)); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {conn.close();} catch(SQLException e) {};
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {};
			if(conn!=null) try {conn.close();} catch(SQLException e) {};
		}
		return list;
	}

	@Override
	public int update(BoardVO boardVo) {
		int cnt=0; //반환값이 저장될 변수
		try {
			conn = DBUtil3.getConnection2();
		     
			String sql = " update jdbc_board set "
					+" board_title =?, board_writer = ?, board_date = sysdate, board_content =? "
					+" where board_no =? ";
		         
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_writer());
			pstmt.setString(3, boardVo.getBoard_content());
			pstmt.setInt(4, boardVo.getBoard_no());  
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
	public List<BoardVO> display() {
		List<BoardVO> list=new ArrayList<BoardVO>();
		try {
			conn=DBUtil.getConnection2();
			String sql="select board_no, board_title, board_writer, board_cnt from jdbc_board";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int no=rs.getInt("board_no");
				String title=rs.getString("board_title");
				String writer=rs.getString("board_writer");
				String cnt=rs.getString("board_cnt");
				list.add(new BoardVO(title, writer, cnt, no)); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {conn.close();} catch(SQLException e) {};
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {};
			if(conn!=null) try {conn.close();} catch(SQLException e) {};
		}
		return list;
	}
	@Override
	public void updateCnt(int board_no) {
		int cnt=0;
		try {
			conn=DBUtil3.getConnection2();
			String sql="UPDATE jdbc_board SET board_cnt = board_cnt+1 WHERE board_no = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {};
			if(conn!=null) try {conn.close();} catch(SQLException e) {};
		}
	}

}

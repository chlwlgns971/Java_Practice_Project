package MVCBoard;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Util.BoardSqlMapClientFactory;

public class BoardDaoIBatis implements BoardDao {
	BoardSqlMapClientFactory scf;
	
	//Singleton
	private static BoardDaoIBatis dao;
	private BoardDaoIBatis() {
		scf=new BoardSqlMapClientFactory(); 
	}
	public static BoardDaoIBatis getInstance() {
		if(dao==null) dao=new BoardDaoIBatis();
		return dao;
	}

	@Override
	public int insert(BoardVO boardVo) {
		int cnt=0;
		try {
			Object obj=scf.getSmc().insert("Board.insertBoard",boardVo);
			if(obj==null) cnt=1;
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int delete(int board_no) {
		int cnt=0;
		try {
			cnt=scf.getSmc().delete("Board.deleteBoard",board_no);
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
			list=scf.getSmc().queryForList("Board.showPost",board_no);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BoardVO> searchPost(String keyWord) {
		List<BoardVO> list=new ArrayList<BoardVO>();
		try {
			list=scf.getSmc().queryForList("Board.searchPost",keyWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(BoardVO boardVo) {
		int cnt=0; //반환값이 저장될 변수
		try {
			cnt=scf.getSmc().update("Board.updateBoard",boardVo);
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public List<BoardVO> display() {
		List<BoardVO> list=new ArrayList<BoardVO>();
		try {
			list=scf.getSmc().queryForList("Board.display");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void updateCnt(int board_no) {
		int cnt=0;
		try {
			cnt=scf.getSmc().update("Board.updateCnt",board_no);
		} catch (SQLException e) {
			cnt=0;
			e.printStackTrace();
		}
	}

}

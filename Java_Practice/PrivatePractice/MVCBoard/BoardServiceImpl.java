package MVCBoard;

import java.util.List;

import MVC.IMemberDao;

public class BoardServiceImpl implements BoardService {
	private BoardDaoImpl dao; // DAO 객체가 저장될 변수 선언
	
	private static BoardServiceImpl service;
	private BoardServiceImpl() {
		dao=BoardDaoImpl.getInstance();
	}
	public static BoardServiceImpl getInstance() {
		if(service==null) service=new BoardServiceImpl();
		return service;
	}

	@Override
	public int insert(BoardVO boardVo) {
		return dao.insert(boardVo);
	}

	@Override
	public int delete(int board_no) {
		return dao.delete(board_no);
	}

	@Override
	public List<BoardVO> showPost(int board_no) {
		return dao.showPost(board_no);
	}

	@Override
	public List<BoardVO> searchPost(String keyWord) {
		return dao.searchPost(keyWord);
	}

	@Override
	public int update(BoardVO boardVo) {
		return dao.update(boardVo);
	}
	
}

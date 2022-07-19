package MVCBoard;

import java.util.List;

public interface BoardService {
	/**
	 * BoardVO에 담긴 게시글 내용을 DB에 insert
	 * @param boardVo
	 * @return insert 성공: 1 실패: 0
	 */
	public int insert(BoardVO boardVo);
	
	/**
	 * 게시글 번호를 입력받아 게시글 삭제
	 * @param board_no
	 * @return delete 성공: 1 실패: 0
	 */
	public int delete(int board_no);
	
	/**
	 * 게시글 번호를 입력받아 게시물보기
	 * @param board_no
	 * @return 게시물정보가 담긴 List
	 */
	public List<BoardVO> showPost(int board_no);
	
	/**
	 * 키워드를 입력받아 게시글 검색
	 * @param keyWord
	 * @return 검색된 게시물 정보가 담긴 List
	 */
	public List<BoardVO> searchPost(String keyWord);
	
	/**
	 * BoardVO 객체를 이용하여 게시글 수정
	 * @param boardVo
	 * @return update 성공: 1 실패: 0
	 */
	public int update(BoardVO boardVo);
	
	/**
	 * 홈에 게시판 띄우기용 메서드
	 * @return 게시글 정보가 담긴 List
	 */
	public List<BoardVO> display();
	
	/**
	 * 조회수+1 시키는 메서드
	 * @param board_no
	 */
	public void updateCnt(int board_no);
}
